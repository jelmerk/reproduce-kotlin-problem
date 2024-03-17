#!/usr/bin/env bash

./gradlew clean build

echo "Does not crash"
java -Xmx1024m -jar ./app/build/libs/app-standalone.jar

sleep 2

echo "Crashes with out of memory"
java -Xmx1024m -jar ./app/build/libs/app-standalone.jar true