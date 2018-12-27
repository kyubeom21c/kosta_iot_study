#!/bin/bash

clear
echo $0

arr=(1 2 3)
echo ${arr[0]}
echo ${arr[1]}
echo ${arr[2]}
echo ${arr[@]}
for i in ${arr[@]}
do
	echo $i
done

names=("kim" "lee" "yang")
echo ${names[0]}
for name in ${names[@]}
do
	echo $name
done





exit 0
