#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"


kor=$(yad --title "Score" --entry --text "kor:") result=$?
echo $result
if ((result==0)) ; then
	echo "OK"
	echo $kor
else
	exit 0
fi

eng=$(yad --title "Score" --entry --text "eng:") result=$?
echo $result
if ((result==0)) ; then
	echo "OK"
	echo $eng
else
	exit 0
fi

echo "total:" $((kor+eng))

exit 0
