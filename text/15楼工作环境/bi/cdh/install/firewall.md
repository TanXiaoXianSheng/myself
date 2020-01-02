# 防火墙核selinux

+ 关闭防火墙  
`chkconfig iptables off`
+ 关闭selinux(没做过)  
SELinux主要作用就是最大限度地减小系统中服务进程可访问的资源（最小权限原则）  
`vi /etc/selinux/config`  
`SELINUX=disabled`  
重启检查 `sestatus -v`  
出现disable即为成功