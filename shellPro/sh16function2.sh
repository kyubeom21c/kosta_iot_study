#!/bin/bash

clear
pwd
echo $0

getParameter(){
	echo "getParameter()..."
	echo $1 $2 $3
	echo $(($1+$2+$3))
	return
}
getParameter 11 22 33


sum(){
	local total=0
#	until [ $# = 0  ]
	until(($#==0))
	do
		total=$((total+$1))
		shift
	done
	echo "total:$total"
}


#sum 44 55 66
x=$(sum 44 55 66)
echo "x:$x"


readLine(){
	echo "readLine().."
	read -p "input kor:" kor
	echo "kor:$kor"

}

readLine


exit 0
