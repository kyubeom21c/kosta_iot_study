#!/bin/bash
echo "yad(Yet Another Dialog)"
echo "sudo apt install yad"


entry=$(yad --width 300 --title "EntryDialog" --entry --text "Language??:") result=$?
echo $result


if ((result==0)) ; then
	echo "OK"
	echo $entry
	sqlite3 test.db "insert into test(name) values('$entry')"
	sqlite3 test.db "select * from test"
else
	echo "Cancel"
fi



exit 0
