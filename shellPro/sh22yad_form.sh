#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"


form=$(yad --width 300 --title "FormDialog" --form --field "name" --field "tel" "kim" "010") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $form
	echo $form | awk 'BEGIN {FS="|"} {print $1}'
	echo $form | awk 'BEGIN {FS="|"} {print $2}'
	
else
	echo "Cancel"
fi



exit 0
