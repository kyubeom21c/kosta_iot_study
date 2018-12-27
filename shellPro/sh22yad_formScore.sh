#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"


form=$(yad --width 300 --title "FormDialog" --form --field "name" --field "kor" --field "eng" "kim" "99" "88") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $form
	
	name=$(echo $form | awk 'BEGIN {FS="|"} {print $1}')
	kor=$(echo $form | awk 'BEGIN {FS="|"} {print $2}')
	eng=$(echo $form | awk 'BEGIN {FS="|"} {print $3}')
	echo $name $kor $eng
	total=$((kor+eng))
	echo "total:$total"
else
	echo "Cancel"
fi



exit 0
