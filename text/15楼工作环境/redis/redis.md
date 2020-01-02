# Redis
采用哨兵机制部署

## 集群配置
### redis集群
主机名|IP|用户名|密码|端口|安装位置
:-:|:-:|:-:|:-:|:-:|:-
localhost|192.168.9.19|root|123.com|7000|/lamp/redis-4.0.12
localhost|192.168.9.21|root|123.com|7000|/lamp/redis-4.0.12
localhost|192.168.9.21|root|123.com|7001|/lamp/redis-4.0.12

## 哨兵集群
主机名|IP|用户名|密码|端口
:-:|:-:|:-:|:-:|:-:
localhost|192.168.9.19|root|123.com|27000
localhost|192.168.9.21|root|123.com|27000
localhost|192.168.9.21|root|123.com|27001

## 启动
要先启动全部的redis-server，再启动redis-sentinel
#### 192.168.9.19上启动
```
[root@localhost redis-4.0.12]# ./src/redis-server ./conf/redis-slave.conf
[root@localhost redis-4.0.12]# nohup ./src/redis-sentinel ./conf/sentinel-slave.conf &
```

#### 192.168.9.21上启动  
```
[root@localhost redis-4.0.12]# ./src/redis-server ./conf/redis-slave.conf
[root@localhost redis-4.0.12]# ./src/redis-server ./conf/redis-master.conf
[root@localhost redis-4.0.12]# nohup ./src/redis-sentinel ./conf/sentinel-slave.conf &
[root@localhost redis-4.0.12]# nohup ./src/redis-sentinel ./conf/sentinel-master.conf &
```

## 查看启动情况
```
[root@localhost ~]# /lamp/redis-4.0.12/src/redis-cli -p 7001
127.0.0.1:7001> info replication
# Replication
role:slave
master_host:192.168.9.21
master_port:7000
master_link_status:up
master_last_io_seconds_ago:1
master_sync_in_progress:0
slave_repl_offset:1583789
slave_priority:90
slave_read_only:1
connected_slaves:0
master_replid:fe0f0e3a654f4d05262d9c7e183de2386e2a1035
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:1583789
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:535214
repl_backlog_histlen:1048576
127.0.0.1:7001>exit
```
从上面输出中可以看出，主节点是`192.168.9.21:7000`，再退出登录主节点  
```
[root@localhost ~]# /lamp/redis-4.0.12/src/redis-cli -p 7000
127.0.0.1:7000> info replication
# Replication
role:master
connected_slaves:2
slave0:ip=192.168.9.19,port=7000,state=online,offset=1608054,lag=1
slave1:ip=192.168.9.21,port=7001,state=online,offset=1608054,lag=1
master_replid:fe0f0e3a654f4d05262d9c7e183de2386e2a1035
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:1608195
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:559620
repl_backlog_histlen:1048576
127.0.0.1:7000>
```
从输出中可以看到master及slave的ip和端口