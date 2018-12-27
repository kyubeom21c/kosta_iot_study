#!/usr/bin/env python
# -*- coding: utf-8 -*-
import requests
print("requests")

req = requests.get("http://192.168.0.191")

print(req.status_code)
print(req.headers)
print(req.content)





