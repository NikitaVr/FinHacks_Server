from flask import Flask, render_template, request, jsonify
from pprint import pprint
from pymongo import MongoClient
import ast
app = Flask(__name__)
client = MongoClient('localhost',27017)
db = client.FinhacksDB
app_users = db.appUsers
transactions = db.transactions
def get_userdata(username,collection_name):
    ret_user = collection_name.find_one({"username":username})
    return ret_user

def debug_table(collection):
    ret = ""
    cursor = collection.find({})
    for document in cursor: 
        ret += str(document) +"\n"
    return ret 

def add_user(query, collection):
    try:
        rer_user = collection.insert({"username":query["username"],"password":query["password"],"friends":[],"balance":0,"upVote":0,"downVote":0})
        return "Success"
    except:
        return "Failed"

def insert_friend(query,collection):
    try:
       ret_usr1 = collection.find_one({"username":query["usr1"]})
       ret_usr2 =  collection.find_one({"username":query["usr2"]})
       if not(ret_usr1["_id"] in ret_usr2["friends"]):
           collection.update({"_id":ret_usr1["_id"]},{"$push":{"friends":ret_usr2["_id"]}})
           collection.update({"_id":ret_usr2["_id"]},{"$push":{"friends":ret_usr1["_id"]}})
           return "success"
       else:
           return "Failed"
    except:
        return "None"
def update_pass(query,collection):
    try:
        collection.update({"username":query["username"]},{"$set":{"password":query["new_password"]}})
        return "Success"
    except:
        return "Failed"


def comparePass(query,collection_name):
    ret_user = collection_name.find_one({"username":query["username"],"password":query["password"]})
    return str(ret_user != None)

def processTransaction(transactionDict):
    userTo = get_userdata(transactionDict["userToName"], app_users)
    userFrom = get_userdata(transactionDict["userFromName"], app_users)
    transactions.insert(
        {"userTo" : userTo["_id"],
        "userFrom" : userFrom["_id"],
        "amount" : transactionDict["amount"],
        "type" : transactionDict["type"],
        "transactionDate" : transactionDict["transactionDate"],
        "expectedReturnDate" : transactionDict["expectedReturnDate"]})
        
    app_users.update(
    {"username": transactionDict["userToName"]},
    { "$inc": { "balance": int(transactionDict["amount"])} },
        upsert = False
    )
    
    app_users.update(
    {"username": transactionDict["userFromName"]},
    { "$inc": { "balance": -int(transactionDict["amount"])} },
        upsert = False
    )
    
    return "Success"
    
def increment_karma(query,collection):
    collection.update({"username":query["username"]},{"$inc":{"upVote":1}})

def decrement_karma(query,collection):
    collection.update({"username":query["username"]},{"$inc":{"downVote":1}})

@app.route("/")
def index():
    return render_template("index.html")
@app.route("/addkarma",methods=["POST"])
def add_karma():
     json = request.json
     try:
         increment_karma(json,app_users)
         return "Success"
     except:
         return "Failed"
@app.route("/decreasekarma",methods=["POST"])
def decrease_karma():
     json = request.json
     try:
         decrement_karma(json,app_users)
         return "Success"
     except:
         return "Failed"
@app.route("/addfriend",methods=["POST"])
def addfriend():
     json = request.json
     addfriendverify = insert_friend(json,app_users)
     return addfriendverify 
@app.route('/post', methods = ['POST']) 
def post():
    # Get the parsed contents of the form da
    json = request.json
    usr_data = get_userdata(json["username"],app_users)
    return str(usr_data)
@app.route('/verify', methods = ['POST'])
def verify():
    # Get the parsed contents of the form da
    json = request.json
    verified = comparePass(json,app_users)
    return verified    
@app.route('/debug',methods = ['POST'])
def debug():
    ret = debug_table(app_users)
    return ret
@app.route('/changepass', methods = ['POST'])
def changepass():
    # Get the parsed contents of the form da
    json = request.json
    verified = comparePass(json,app_users)
    if(verified == "True"):
        return update_pass(json,app_users)
    else:
        return "Original password is not correct"
@app.route('/transaction', methods = ['POST']) 
def postTransaction():
    # Get the parsed contents of the form data
    json = request.json
    
    response = processTransaction(json)
    return response

if __name__ == '__main__':
    app.run(
        host = "0.0.0.0",
        port = 80
    )

