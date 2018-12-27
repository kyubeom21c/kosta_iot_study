#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"
resultSet=$(echo $(sqlite3 test.db "select * from test"))
IFS='| ' read -ra names <<< "$resultSet"

echo "names.length:${#names[@]}"
echo "names[0].length:${#names[0]}"


onSelectedItem=$(yad --width=300 --height=200 --title "ListDialog" --list --column=NUM --column=NAME "${names[@]}") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $onSelectedItem
	echo $onSelectedItem | awk 'BEGIN {FS="|"} {print $1}'
	echo $onSelectedItem | awk 'BEGIN {FS="|"} {print $2}'
else
	echo "Cancel"
fi



exit 0
