#!/bin/bash

echo $0


#while [ 1  ]
#while :
#while true
su=5
while (($su==5))
do
	echo "finish input key[x/X]:"
	read key
	case $key in
		[xX])break;;
#		[xX])return;;
#		[xX])exit 0;;
	esac
done

echo "end while"




exit 0
