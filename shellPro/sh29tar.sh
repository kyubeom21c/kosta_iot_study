#!/bin/bash

clear
pwd
echo $0
cd /home/kosta/shellPro
#all sh file tar.gz make -cvzf
tar -cvzf test.tar.gz *.sh
ls -al
#mkdir shells , tar.gz mv , -xvzf
mkdir shells
mv test.tar.gz shells/

cd shells

tar -xvzf test.tar.gz





exit 0
