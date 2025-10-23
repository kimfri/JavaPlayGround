#!/bin/bash

CLASSPATH=target/SomeTests-1.0-SNAPSHOT.jar
for f in target/dependency/*.jar; do
    CLASSPATH=$CLASSPATH";$f"
done

#echo $CLASSPATH

java -cp $CLASSPATH \
 -DaccessKey=myCoolKey \
 $1