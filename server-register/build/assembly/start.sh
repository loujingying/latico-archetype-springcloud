#!/bin/bash
# ${project.build.finalName}
export programname=$(cat ./programname.cfg)
export javapath=$(cat ./javapath.cfg)
workdir=$(cd $(dirname $0); pwd)

PID=`ps -ef|grep $workdir|grep ${programname}|grep -v grep|awk '{print $2}'`

if [ -z $PID ];then
    ${javapath} -Dprogramname=${programname} -Dprogrampath=$workdir -XX:+HeapDumpOnOutOfMemoryError -Dloader.path=lib -jar lib/${programname}.jar >/dev/null 2>err.log &
else
    echo "PID=$PID the program <<$workdir && ${programname}>> has been running.Please stop it firstly."
fi