#!/bin/sh 
# vim: set sw=4 ts=4 et: 
help() 
{ 
　cat < b2h -- convert binary to decimal 
USAGE: b2h [-h] binarynum 
OPTIONS: -h help text 
EXAMPLE: b2h 111010 
will return 58 
HELP 
　exit 0 
} 
error() 
{ 
　　# print an error and exit 
　　echo "$1" 
　　exit 1 
} 
lastchar() 
{ 
　　# return the last character of a string in $rval 
　　if [ -z "$1" ]; then 
　　　　# empty string 
　　　　rval="" 
　　　　return 
　　fi 
　　# wc puts some space behind the output this is why we need sed: 
　　numofchar=`echo -n "$1" | wc -c | sed 's/ //g' ` 
　　# now cut out the last char 
　　rval=`echo -n "$1" | cut -b $numofchar` 
} 
chop() 
{ 
　　# remove the last character in string and return it in $rval 
　　if [ -z "$1" ]; then 
　　　　# empty string 
　　　　rval="" 
　　　　return 
　　fi 
　　# wc puts some space behind the output this is why we need sed: 
　　numofchar=`echo -n "$1" | wc -c | sed 's/ //g' ` 
　　if [ "$numofchar" = "1" ]; then 
　　　　# only one char in string 
　　　　rval="" 
　　　　return 
　　fi 
　　numofcharminus1=`expr $numofchar "-" 1` 
　　# now cut all but the last char: 
　　rval=`echo -n "$1" | cut -b 0-${numofcharminus1}` 
} 
while [ -n "$1" ]; do 
case $1 in 
　　-h) help;shift 1;; # function help is called 
　　--) shift;break;; # end of options 
　　-*) error "error: no such option $1. -h for help";; 
　　*) break;; 
esac 
done 
# The main program 
sum=0 
weight=1 
# one arg must be given: 
[ -z "$1" ] && help 
binnum="$1" 
binnumorig="$1" 
while [ -n "$binnum" ]; do 
　　lastchar "$binnum" 
　　if [ "$rval" = "1" ]; then 
　　　　sum=`expr "$weight" "+" "$sum"` 
　　fi 
　　# remove the last position in $binnum 
　　chop "$binnum" 
　　binnum="$rval" 
　　weight=`expr "$weight" "*" 2` 
done 
echo "binary $binnumorig is decimal $sum" 
# 