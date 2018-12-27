#!/bin/bash
echo hello sqlite

sqlite3 test.db "select * from test"

sqlite3 test.db "insert into test(name) values('kim')"
sqlite3 test.db "insert into test(name) values('kim')"
sqlite3 test.db "insert into test(name) values('kim')"
sqlite3 test.db "insert into test(name) values('kim')"

echo
echo $(sqlite3 test.db "select * from test")


exit 0
