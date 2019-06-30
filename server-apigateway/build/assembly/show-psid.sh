#!/bin/bash
# {project.build.finalName}
export programname=$(cat ./programname.cfg)
workdir=$(cd $(dirname $0); pwd)

PID=`ps -ef|grep $workdir|grep ${programname}|grep -v grep|awk '{print $2}'`
if [ -z $PID ];then
    echo "The program <<$workdir && ${programname}>> has been stoped."
else
    echo $PID
fi