#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"

alert=$(yad) result=$?
echo $result

if ((result==0)) ; then
	echo "OK"
	rm index*
	ls
else
	echo "Cancel"
fi


alert=$(yad --width 300 --title "Are you OK?" --button="message:2") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
else
	echo "Cancel"
fi



exit 0
