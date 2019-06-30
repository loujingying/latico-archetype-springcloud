一、配置修改
1、java路径和内存配置修改文件（根据需求修改）：javapath.cfg；

2、程序名称和启动包名称配置文件（默认不需要修改）：programname.cfg；

3、指定程序使用的配置文件（生产环境建议使用prod），在application.properties文件中，
    指定为：dev（开发环境）或 test（测试环境）、prod（生产环境），

4、正常情况，可执行文件:start.bat、start.sh、show-psid.sh、stop.sh，不允许更改；

二、程序启动与关闭
1、windows下
    1.1、启动：双击启动start.bat (需要把bat格式文件调成可执行文件，默认一般都已经是)
    1.2、关闭：直接关闭bat窗口
2、linux下
    2.1启动 ：
        执行命令：  sh ./start.sh
    2.2、查看进程ID
        执行命令： sh ./show-psid.sh
    2.3、停止进程
        执行命令： sh ./stop.sh