#!/usr/bin/env python
# -*- coding: utf-8 -*-

import subprocess
print("subprocess")

#https://docs.python.org/2.7/library/subprocess.html

#subprocess.call("ls -al | more",shell=True)
#subprocess.call("sh ./test23.sh",shell=True)

lst = [11,22,33]
subprocess.call("echo {}".format(lst[0]),shell=True)
##########################################

lst = ["test23.sh","test24.sh"]
value = "cat {}".format(lst[0])
subprocess.call(value,shell=True)
##########################################


