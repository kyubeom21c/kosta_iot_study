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

if [ $1 = 100 ] || [ $2 = 100 ]
then echo "aaaaaaa2"
else echo "bbbbbbb2"
fi

if [ $1 = 100 -a  $2 = 200 ]
then echo "aaaaaaa3"
else echo "bbbbbbb3"
fi

if [ $1 = 100 -o $2 = 100 ]
then echo "aaaaaaa4"
else echo "bbbbbbb4"
fi

if [ $1 = 200 -o -f /home/kosta/shellPro/sh01hello.sh ]
then head -5 /home/kosta/shellPro/sh01hello.sh
else echo "bbbbbbb4"
fi



if [ -f /home/kosta/shellPro/test.txt ]
then echo "aaa"
else echo "bbb"
fi

if [ -f /home/kosta/shellPro/test.txt ]
then cat /home/kosta/shellPro/test.txt
else echo "file not found..."
fi

if [ -x /home/kosta/shellPro/sh01hello.sh ]
then sh /home/kosta/shellPro/sh01hello.sh
else echo "file not found..."
fi

echo "====="

if [ -x /home/kosta/shellPro/sh06case.sh ]
then sh /home/kosta/shellPro/sh06case.sh
else chmod u+x /home/kosta/shellPro/sh06case.sh;
	sh /home/kosta/shellPro/sh06case.sh
fi



exit 0
