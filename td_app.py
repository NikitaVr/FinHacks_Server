from flask import Flask, render_template, request, jsonify
from pprint import pprint
from pymongo import MongoClient
app = Flask(__name__)
client = MongoClient('localhost',27017)
db = client.FinhacksDB
app_users = db.appUsers
transactions = db.transactions
list_data = app_users.find({})
for i in list_data:
    pprint(i)
app_users.update(
   {"username":"Bob"},
   { "$inc": { "balance": -1000} },
upsert = False
)
def get_userdata(username,collection_name):
    ret_user = collection_name.find_one({"username":username})
    return ret_user

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
    
        
    
list_data = app_users.find({})
for i in list_data:
    pprint(i)

@app.route("/")
def index():
    return "Hello World, send me a POST request"
@app.route('/post', methods = ['POST']) 
def post():
    # Get the parsed contents of the form data
    json = request.json
    usr_data = get_userdata(json["username"],app_users)
    return str(usr_data)
    
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
