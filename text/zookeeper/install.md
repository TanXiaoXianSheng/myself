# Zookeeper集群安装（三节点）

### 下载
`wget http://mirrors.hust.edu.cn/apache/zookeeper/zookeeper-3.5.6/apache-zookeeper-3.5.6-bin.tar.gz`
### 解压 & 改名 & 移动
```
tar -zxvf apache-zookeeper-3.5.6-bin.tar.gz
mv apache-zookeeper-3.5.6-bin /opt/
mv apache-zookeeper-3.5.6-bin/ zookeeper-3.5.6
```
### 添加环境变量（非必需）
`vim /etc/profile`
```
export ZOOKEEPER_HOME=/opt/zookeeper-3.5.6
export PATH=$PATH:$ZOOKEEPER_HOME/bin
```
`source /etc/profile`
### 创建data目录 & 修改配置文件
```
mkdir data
cp conf/zoo_sample.cfg conf/zoo.cfg
vim zoo.cfg
```
修改为：  
```
dataDir=/opt/zookeeper-3.5.6/data

server.0=192.168.195.200:2888:3888
server.1=192.168.195.201:2888:3888
server.2=192.168.195.202:2888:3888
```
2181：client端口  
2888：节点通信  
3888：节点选举
### 在data目录下创建myid文件，写入对应的编号
`0、1 or 2`

### 启动
`zkServer.sh start`
### 查看状态
` zkServer.sh status`
