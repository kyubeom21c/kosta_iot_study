#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json

data_file=open("test32.json").read()
print("data_file:",data_file)
print("type(data_file):",type(data_file))

json_data=json.loads(data_file)
print("json_data:",json_data)
print("type(json_data):",type(json_data))
print(json_data["name"])
print(json_data["age"])
print(json_data["subject"][0])
print(json_data["subject"][1])
print(json_data["subject"][2])



