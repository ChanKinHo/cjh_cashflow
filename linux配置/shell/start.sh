#!/bin/sh
APP_NAME=cjh_cashflow-0.0.1-SNAPSHOT.jar

PID=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
if [ -z "$PID" ]
then
    nohup java -jar $APP_NAME > /houseapps/cashflow/boot/tomcat/catalina.out 2>&1 &
else
    echo $APP_NAME already exist
fi
