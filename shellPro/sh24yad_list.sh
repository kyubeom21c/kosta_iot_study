#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"

names=("yangssem" "88" "99")
names+=("kim" "88" "99")
names+=("kim" "88" "99")
names+=("kim" "88" "99")
names+=("kim" "88" "99")
names+=("kim" "88" "99")

echo "names.length:${#names[@]}"
echo "names[0].length:${#names[0]}"

onSelectedItem=$(yad --width=300 --height=200 --title "ListDialog" --list --column=NAME --column=KOR  --column=ENG "${names[@]}") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $onSelectedItem
	echo $onSelectedItem | awk 'BEGIN {FS="|"} {print $1}'
	echo $onSelectedItem | awk 'BEGIN {FS="|"} {print $2}'
	echo $onSelectedItem | awk 'BEGIN {FS="|"} {print $3}'
else
	echo "Cancel"
fi



exit 0
