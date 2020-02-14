# docker
### 启动docker
`systemctl start docker`
### 关闭docker
`systemctl stop docker`
### 导出容器
`docker export 容器ID > 导出包名.tar`
### 导入容器
`docker import 导出包名.tar 导入容器名:版本`
### 运行导入的容器
`docker start 导入容器名:版本`
