#!/bin/bash


FILES=`find . -exec file {} \; | grep ISO-8859 | awk -F: '{print $1}'`



for FILE in $FILES; do

	echo $FILE
	iconv -f ISO-8859-1 -t UTF-8 "$FILE" -o "$FILE"-utf8.tmp
	mv $FILE-utf8.tmp "$FILE"
done

