#!/bin/bash

clear
pwd
echo $0

read -p "input date[ex:2020-10-10]:" date

pat_date="^[0-9]{8}$"
pat_date="^[0-9]{4}-[0-9]{2}-[0-9]{2}$"

#=~

if [[ $date =~ $pat_date  ]]
then
	echo "good"
else
	echo "bad"
fi

exit 0
