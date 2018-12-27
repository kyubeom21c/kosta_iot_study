#!/usr/bin/env python
# -*- coding: utf-8 -*-

import re
print("regExp : Regular Expressions")

#[]>> word
#. >> \nf 를제외 한    문 자
#(*) >> 0개이 상반 복
#(+) >> 1개이 상반 복
#{m,n} >>ea count

pattern = re.compile("(\d{6})[-]\d{7}")
data = "kim 123456-1234567 010-1111-1111 lee 222222-2222222 010-2222-2222"
print(pattern.sub("\g<1>-*******",data))
print(pattern.sub("\g<1>-1******",data))


