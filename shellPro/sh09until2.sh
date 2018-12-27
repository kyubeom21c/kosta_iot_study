#!/bin/bash


echo $0

echo "args length:" $#

until [ $# = 0 ]
do
	echo $1
	sum=$(($sum+$1))
	shift
	echo $#

done
echo "sum:$sum"



exit 0



