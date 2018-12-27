#!/bin/bash

clear
pwd
echo $0

name="yangssem"
printPWD(){
	echo "function.."
	echo $name
	local name="kim"
	echo $name
	pwd
	return
}
printPWD


exit 0
