# IP配置


## centos 7静态ip配置
1. 查看ip  
`ip addr`

```
[root@cdh01 network-scripts]# iip addr
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host
       valid_lft forever preferred_lft forever
2: eno16777736: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state UP qlen 1000
    link/ether 00:0c:29:6e:7b:c1 brd ff:ff:ff:ff:ff:ff
    inet 192.168.9.133/24 brd 192.168.9.255 scope global eno16777736
       valid_lft forever preferred_lft forever
    inet6 fe80::20c:29ff:fe6e:7bc1/64 scope link
       valid_lft forever preferred_lft forever
[root@cdh01 network-scripts]#
```
从返回中可以看出，ipv4地址为192.168.9.133，使用网卡为eno16777736
2. 进入目录  
`cd /etc/sysconfig/network-scripts/`
3. 修改配置文件  
`vim ifcfg-eno16777736`
由于这个是直接克隆的别人的centos7，之前别人已经配置过，这里只修改了ip就可以了，完整配置如下：  
```
TYPE=Ethernet
BOOTPROTO=static
DEFROUTE=yes
IPV4_FAILURE_FATAL=no
NAME=eno16777736
UUID=820dd101-4bfb-4be9-8f70-bc21972f9590
DEVICE=eno16777736
ONBOOT=yes
IPADDR=192.168.9.133
PREFIX=24
GATEWAY=192.168.9.254
DNS1=192.168.9.254
```
4. 重启网络服务  
`service network restart`