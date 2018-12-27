#!/bin/bash


echo "until"
key="x"
until [ $key = "y" ]
do
	echo "end y"
	read key
done
