# 主机名配置

### 1.方法一（不用重启）
 ```
[root@cdh14 ~]# hostnamectl set-hostname cdh01
[root@cdh14 ~]# hostname
cdh01
 ```  

 ### 2.方法二(每试过，重启生效)
 + `[root@cdh14 ~]# vim /etc/hosts`

 + 增加主机名
 ```
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4 cdh01
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
192.168.9.133 cdh01
```   

### 3.方法三（不用重启）
`vi /etc/hostname`