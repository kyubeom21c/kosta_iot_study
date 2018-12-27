#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"


entry=$(yad --width 300 --title "EntryDialog" --entry --text "Language??:") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $entry
	case $entry in
		linux|Linux)echo "Shell Programe";;
		java|Java|JAVA)echo "Good java";;
	esac
else
	echo "Cancel"
fi



exit 0
