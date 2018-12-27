#!/bin/bash
clear

echo $0

kor=100
eng=90
math=80

total=`expr $kor + $eng + $math`
echo "expr total:$total"

total=$(($kor+$eng+$math))
echo "(())total:$total"

let total=kor+eng+math
echo "let total:$total"

su=100
sum=$(($su**2))
echo $sum
echo $((sum++))
echo $((sum++))
echo $((sum++))
echo $((sum++))
echo $((--sum))
echo $((--sum))
echo $((--sum))
echo $((--sum))

x=11
y=22
echo $(python -c "print $x+$y")



exit 0
