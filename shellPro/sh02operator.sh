#!/bin/bash
#aaaaamyangssem

su1=100
su2=3
su3=`expr $su1 + $su2`
printf "kor:%d+%d=%d\n" $su1 $su2 $su3

su3=`expr $su1 - $su2`
printf "kor:%d-%d=%d\n" $su1 $su2 $su3


su3=`expr $su1 \* $su2`
printf "kor:%d*%d=%d\n" $su1 $su2 $su3

su3=`expr $su1 / $su2`
printf "kor:%d/%d=%.2f\n" $su1 $su2 $su3


su3=`expr $su1 % $su2`
printf "kor:%d %% %d=%d\n" $su1 $su2 $su3


echo "$su1+$su2"
echo `expr $su1 + $su2`
echo $(($su1+$su2))

echo $(($su1-$su2))

echo $(($su1*$su2))

echo $(($su1/$su2))

echo $(($su1%$su2))
exit 0
