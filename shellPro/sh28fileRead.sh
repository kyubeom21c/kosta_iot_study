#!/bin/bash

clear
pwd
echo $0

while read kor eng math
do
	echo $kor $eng $math
done < sh28score.txt

while read line
do
	echo $line
done < sh28text.txt



exit 0
