# 防火墙配置

### 查看防火墙状态
`firewall-cmd --state`
### 启动防火墙
`systemctl start firewalld`

### 关闭防火墙
`systemctl stop firewalld`

### 禁用防火墙
`systemctl disable firewalld.service`

### 检查防火墙开放的端口
`firewall-cmd --permanent --zone=public --list-ports`
### 开放一个新的端口
`firewall-cmd --zone=public --add-port=8080/tcp --permanent`
### 重启防火墙
`firewall-cmd --reload`
### 验证新增加端口是否生效
`firewall-cmd --zone=public --query-port=8080/tcp`
### 防火墙开机自启动
`systemctl enable firewalld.service`
### 防火墙取消某一开放端口
`firewall-cmd --zone=public --remove-port=9200/tcp --permanent`
