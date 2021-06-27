#!/bin/sh
APP_NAME=cjh_cashflow-0.0.1-SNAPSHOT.jar

PID=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
if [ -z "$PID" ]
then
    echo $APP_NAME is already stopped
else
    echo killing $PID
    kill -9 $PID
fi