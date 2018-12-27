#!/bin/bash

echo "for"

for((i=0;i<10;i++))
do
	echo "aaa" $i
done

for((i=0;i<10;i++))
do
	printf "%d\t" $i
done
echo

echo "=============="

for i in 10 20 30
do
	printf "%d\t" $i
done
echo

for i in `seq 90 100`
do
	printf "%d\t" $i
done
echo
echo "==============="

for fileName in $(ls ./sh01hello.sh)
do
	cat $fileName
done
echo

echo "==============="

for fileName in $(ls ./sh*.sh)
do
	echo "====$fileName====="
	cat $fileName
	echo "=================="
done
echo



exit 0
