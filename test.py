#from flask import Flask
from pprint import pprint
from pymongo import MongoClient
client = MongoClient()
client = MongoClient('localhost', 27017)
db = client['FinhacksDB']
collection = db['appUsers']

cursor = collection.find({})

#app = Flask(__name__)
mongo = PyMongo(app)
for document in cursor: 
    pprint(document)

