#!/bin/bash

clear
pwd
echo $0

resultSet="1|kim 2|kim 3|kim 4|kim 5|kim"
echo $resultSet



IFS="| "

read -ra names <<< "$resultSet"
echo ${names[@]}
for item in ${names[@]}
do
	echo $item
done



exit 0
