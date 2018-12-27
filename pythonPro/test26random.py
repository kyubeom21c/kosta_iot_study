#!/usr/bin/env python
# -*- coding: utf-8 -*-
import random
print("random")

for i in range(6):
	print(random.random())
	print(random.random()*10)
	print(random.randrange(1,46))

###########################
card = ['A','J','Q','K']
print(card)
random.shuffle(card)
print(card)
print(random.choice(card))

random.shuffle(card)
print(card)
print(random.choice(card))

###########################
