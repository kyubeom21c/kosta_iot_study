#!/bin/bash

cat test.json | jq '.name'

curl http://192.168.0.191:8090/test.json


curl http://192.168.0.191:8090/test.json | jq '.vo.id'

curl http://192.168.0.191:8090/testList.json | jq '.[] | .name'






exit 0
