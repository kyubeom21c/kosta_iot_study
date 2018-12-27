#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"


form=$(yad --width 300 --title "FormDialog"  --form --field "name" --field "tel" --field="Language:CB" --field="ls -l:FL" --field="Golf:CHK" --field="Baseball:CHK"  "Yangssem" "010" "Linux!Java!Android" "/home/kosta/shellPro" TRUE FALSE) result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $form
	echo $form | awk 'BEGIN {FS="|"} {print $1}'
	echo $form | awk 'BEGIN {FS="|"} {print $2}'
	echo $form | awk 'BEGIN {FS="|"} {print $3}'
	echo $form | awk 'BEGIN {FS="|"} {print $4}'
	echo $form | awk 'BEGIN {FS="|"} {print $5}'
	echo $form | awk 'BEGIN {FS="|"} {print $6}'
	
else
	echo "Cancel"
fi



exit 0
