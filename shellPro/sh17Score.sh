#!/bin/bash


echo $0

readLine(){
	read -p "input name:" name
	read -p "input kor:" kor
	read -p "input eng:" eng
	read -p "input math:" math
	total=$((kor+eng+math))
	avg=$((total/3))
	
	if((avg>=90 && avg<=100))
	then
		grade="A"
	elif((avg>=80))
	then
		grade="B"
	else
		grade="F"
	fi
	
	printf "%s:%d,%d,%d,%d,%d,%s" $name $kor $eng $math $total $avg $grade

}
for((i=0;i<2;i++))
do
	list[i]=$(readLine)
done
echo ${#list[@]}

echo "name:kor,eng,math,total,avg,grade"
for student in ${list[@]}
do
	printf "%s\n" $student
done

exit 0
