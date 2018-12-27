#!/bin/bash


echo $1
echo $2
echo $3

if [ $1 = 100 ]
then echo "aaa"
else echo "bbb"
fi

if [ $2 -eq 200 ]
then echo "ccc"
else echo "ddd"
fi

if [ $3 != 300 ]
then echo "eee"
else echo "fff"
fi

if [ $3 -ne 300 ]
then echo "eee2"
else echo "fff2"
fi


if [ $1 = 100 ] && [ $2 = 200 ]
then echo "aaaaaaa"
else echo "bbbbbbb"
fi


if [ -f /home/kosta/shellPro/test.txt ]
then echo "aaa"
else echo "bbb"
fi



exit 0
