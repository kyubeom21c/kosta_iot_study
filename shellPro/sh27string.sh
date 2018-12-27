#!/bin/bash

clear
pwd
echo $0

text="  The dog1 , dog2 , d		og3  "

echo "text:$text"
echo "text.length:${#text}"

arr=(1 2 3)
echo "arr.length:${#arr[@]}"


echo "text:5,${text:5}"
echo "text:6,${text:6}"
echo "text:7,${text:7}"

echo "text:6:7,${text:6:11}"

echo ${text//[[:blank:]]/}
echo ${text//[[:space:]]/}

echo ${text#*d}

text=${text//[0-9]/"x"}
echo "text:pat,$text"

text=${text//dog/cat}
echo "text:replace,$text"

#space one + -13
echo "back subString:${text: -13:2}"


read -sp "input password:" password
echo $password


exit 0
