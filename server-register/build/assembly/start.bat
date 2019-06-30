set /p programname=<./programname.cfg
set /p javapath=<./javapath.cfg
title %programname%
%javapath% -Dprogramname=%programname% -XX:+HeapDumpOnOutOfMemoryError -Dloader.path=lib -jar lib\%programname%.jar 2>err.log
pause