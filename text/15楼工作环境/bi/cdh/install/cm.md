# 安装Cloudera Manager Server和 Agent


```
[root@cdh01 CDH]# /opt/cm-5.9.3/share/cmf/schema/scm_prepare_database.sh mysql cm -hlocalhost -uroot -p
root --scm-host localhost scm scm scm
JAVA_HOME=/opt/jdk
Verifying that we can write to /opt/cm-5.9.3/etc/cloudera-scm-server
Creating SCM configuration file in /opt/cm-5.9.3/etc/cloudera-scm-server
groups: cloudera-scm: no such user
Executing:  /opt/jdk/bin/java -cp /usr/share/java/mysql-connector-java.jar:/usr/share/java/oracle-connector-java.jar:/opt/cm-5.9.3/share/cmf/schema/../lib/* com.cloudera.enterprise.dbutil.DbCommandExecutor /opt/cm-5.9.3/etc/cloudera-scm-server/db.properties com.cloudera.cmf.db.
2019-08-16 10:25:39,793 [main] INFO  com.cloudera.enterprise.dbutil.DbCommandExecutor  - Successfully connected to database.
All done, your SCM database is configured correctly!
[root@cdh01 CDH]#
```