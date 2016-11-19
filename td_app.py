from flask import Flask, render_template, request, jsonify
from pprint import pprint
from pymongo import MongoClient
app = Flask(__name__)
client = MongoClient('localhost',27017)
db = client.FinhacksDB
app_users = db.appUsers
list_data = app_users.find({})
for i in list_data:
    pprint(i)
app_users.update(
   {"username":"Bob"},
   { "$inc": { "balance": -1000} },
upsert = False
)
def get_userdata(query,collection_name):
    username = query["username"]
    ret_user = collection_name.find_one({"username":username})
    return str(ret_user)


        
    
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
    usr_data = get_userdata(json,app_users)
    return usr_data

if __name__ == '__main__':
    app.run(
        host = "0.0.0.0",
        port = 80
    )
