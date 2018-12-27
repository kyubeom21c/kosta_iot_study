#!/bin/bash

clear
pwd

echo $0

echo "Do you want to remove?input 1 or 2"
select yn in "Yes" "No"
do
	case $yn in
	Yes) echo "removed";;
	No) echo "cancel";;
	esac
	exit
done

exit 0
