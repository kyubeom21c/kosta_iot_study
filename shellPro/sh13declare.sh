#!/bin/bash

clear
echo $0

declare -r NAME="KIM"

declare -a arr=(1 2 3)

declare -i su=100

#i=number, a=array, r=readonly

echo $NAME
echo ${arr[@]}
echo $su

exit 0
