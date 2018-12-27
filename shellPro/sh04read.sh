#!/bin/bash

#echo "input su:"

read -p "input su:" su

echo $su

if (($su==100))
then
	echo "A+"
elif(($su==90))
then
	echo "A"
elif(($su==80))
then
	echo "B"
fi



exit 0
