#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import json
#POST>>python3
import urllib.request
#GET
import requests

#POST
post_url = "http://192.168.0.191:8090/pythonjson/json_insertOK.do"

send_data = {'id':'tester','pw':'hi2468','name':'kim','tel':'031'}
params = json.dumps(send_data).encode("utf-8")
print(params)
req = urllib.request.Request(post_url,params,headers={'content-type':'application/json'})

response = urllib.request.urlopen(req)
response_data = response.read().decode('utf-8')
print(response_data)
json_data=json.loads(response_data)
print("json_data:",json_data)
print("type(json_data):",type(json_data))
print(json_data["result"])



#GET
get_url = "http://192.168.0.191:8090/pythonjson/json_selectAll.do"
req = requests.get(get_url)
print(req.content)
json_data=json.loads(str(req.content,"utf-8"))
print("json_data:",json_data)
print("type(json_data):",type(json_data))

for vo in json_data:
	print(vo["id"])
	print(vo["pw"])
	print(vo["name"])
	print(vo["tel"])
