# jdk安装

### 上传`jdk-xxx.tar.gz`压缩包
### 解压  
`tar -zxvf jdk-xxx.tar.gz`
### 把解压后的jdk移动到`/usr/local/`下  
`mv jdk-xxx /usr/local`
### 配置环境变量  
`vim /etc/profile`
### 添加  
```
export JAVA_HOME=/usr/local/jdk1.8.0_231
export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin
```
### 使配置文件生效  
`source /etc/profile`
### 查看  
 `java -version`
