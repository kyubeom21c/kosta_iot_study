#!/bin/bash

su1=100
su2=100


if [ "$su1" -ge "$su2"  ] ; then
	echo "aaa"
else
	echo "bbb"
fi

if (($su1>=$su2)) ; then
	echo "aaa"
else
	echo "bbb"
fi

if (($su1/2>=$su2)) ; then
	echo "aaa"
else
	echo "bbb"
fi








exit 0
