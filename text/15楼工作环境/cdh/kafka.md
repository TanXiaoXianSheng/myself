# KAFKA(CDH,9092)

### 集群配置
主机名|IP|用户名|密码
:-:|:-:|:-:|:-:
cdh8|192.168.9.9|root|123.com
cdh9|192.168.9.8|root|123.com
cdh10|192.168.9.7|root|123.com

### 启动 & 关闭
由CDH集群统一管理，启动关闭同步CDH

### 位置 & 简单使用
1. 登录cdh8
2. 切换到Kafka目录  
`cd /opt/cloudera/parcels/KAFKA`
3. 发送数据  
`./bin/kafka-console-producer --broker-list cdh8:9092,cdh9:9092,cdh10:9092 --topic topicName`
4. 消费数据  
` ./bin/kafka-console-consumer --bootstrap-server cdh8:9092,cdh9:9092,cdh10:9092 --topic topicName`
