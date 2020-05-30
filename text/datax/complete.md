```
[root@localhost datax]# python bin/datax.py job/mysql2mysql.json

DataX (DATAX-OPENSOURCE-3.0), From Alibaba !
Copyright (C) 2010-2017, Alibaba Group. All Rights Reserved.


java -server -Xms1g -Xmx1g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/root/datax/log -Xms1g -Xmx1g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/root/datax/log -Dloglevel=info -Dfile.encoding=UTF-8 -Dlogback.statusListenerClass=ch.qos.logback.core.status.NopStatusListener -Djava.security.egd=file:///dev/urandom -Ddatax.home=/root/datax -Dlogback.configurationFile=/root/datax/conf/logback.xml -classpath /root/datax/lib/*:.  -Dlog.file.name=job_mysql2mysql_json com.alibaba.datax.core.Engine -mode standalone -jobid -1 -job /root/datax/job/mysql2mysql.json
2020-05-05 20:35:41.811 [main] INFO  VMInfo - VMInfo# operatingSystem class => sun.management.OperatingSystemImpl
2020-05-05 20:35:41.818 [main] INFO  Engine - the machine info  =>

        osInfo: Oracle Corporation 1.8 25.211-b12
        jvmInfo:        Linux amd64 3.10.0-1062.el7.x86_64
        cpu num:        1

        totalPhysicalMemory:    -0.00G
        freePhysicalMemory:     -0.00G
        maxFileDescriptorCount: -1
        currentOpenFileDescriptorCount: -1

        GC Names        [Copy, MarkSweepCompact]

        MEMORY_NAME                    | allocation_size                | init_size
        Eden Space                     | 273.06MB                       | 273.06MB
        Code Cache                     | 240.00MB                       | 2.44MB
        Survivor Space                 | 34.13MB                        | 34.13MB
        Compressed Class Space         | 1,024.00MB                     | 0.00MB
        Metaspace                      | -0.00MB                        | 0.00MB
        Tenured Gen                    | 682.69MB                       | 682.69MB


2020-05-05 20:35:41.843 [main] INFO  Engine -
{
        "content":[
                {
                        "reader":{
                                "name":"mysqlreader",
                                "parameter":{
                                        "column":[
                                                "id",
                                                "user_name",
                                                "create_time"
                                        ],
                                        "connection":[
                                                {
                                                        "jdbcUrl":[
                                                                "jdbc:mysql://192.168.199.201:3307/test"
                                                        ],
                                                        "table":[
                                                                "user"
                                                        ]
                                                }
                                        ],
                                        "password":"****",
                                        "splitPk":"id",
                                        "username":"root"
                                }
                        },
                        "writer":{
                                "name":"mysqlwriter",
                                "parameter":{
                                        "column":[
                                                "id",
                                                "user_name",
                                                "create_time"
                                        ],
                                        "connection":[
                                                {
                                                        "jdbcUrl":"jdbc:mysql://192.168.199.201:3306/test?useUnicode=true&characterEncoding=utf8",
                                                        "table":[
                                                                "user"
                                                        ]
                                                }
                                        ],
                                        "password":"****",
                                        "preSql":[
                                                "delete from user"
                                        ],
                                        "session":[],
                                        "username":"root",
                                        "writeMode":"insert"
                                }
                        }
                }
        ],
        "setting":{
                "errorLimit":{
                        "percentage":0.02,
                        "record":0
                },
                "speed":{
                        "channel":3
                }
        }
}

2020-05-05 20:35:41.865 [main] WARN  Engine - prioriy set to 0, because NumberFormatException, the value is: null
2020-05-05 20:35:41.867 [main] INFO  PerfTrace - PerfTrace traceId=job_-1, isEnable=false, priority=0
2020-05-05 20:35:41.867 [main] INFO  JobContainer - DataX jobContainer starts job.
2020-05-05 20:35:41.877 [main] INFO  JobContainer - Set jobId = 0
2020-05-05 20:35:42.365 [job-0] INFO  OriginalConfPretreatmentUtil - Available jdbcUrl:jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true.
2020-05-05 20:35:42.408 [job-0] INFO  OriginalConfPretreatmentUtil - table:[user] has columns:[id,user_name,create_time].
2020-05-05 20:35:42.717 [job-0] INFO  OriginalConfPretreatmentUtil - table:[user] all columns:[
id,user_name,create_time
].
2020-05-05 20:35:42.728 [job-0] INFO  OriginalConfPretreatmentUtil - Write data [
insert INTO %s (id,user_name,create_time) VALUES(?,?,?)
], which jdbcUrl like:[jdbc:mysql://192.168.199.201:3306/test?useUnicode=true&characterEncoding=utf8&yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true]
2020-05-05 20:35:42.729 [job-0] INFO  JobContainer - jobContainer starts to do prepare ...
2020-05-05 20:35:42.729 [job-0] INFO  JobContainer - DataX Reader.Job [mysqlreader] do prepare work .
2020-05-05 20:35:42.729 [job-0] INFO  JobContainer - DataX Writer.Job [mysqlwriter] do prepare work .
2020-05-05 20:35:42.743 [job-0] INFO  CommonRdbmsWriter$Job - Begin to execute preSqls:[delete from user]. context info:jdbc:mysql://192.168.199.201:3306/test?useUnicode=true&characterEncoding=utf8&yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true.
2020-05-05 20:35:42.747 [job-0] INFO  JobContainer - jobContainer starts to do split ...
2020-05-05 20:35:42.747 [job-0] INFO  JobContainer - Job set Channel-Number to 3 channels.
2020-05-05 20:35:42.765 [job-0] INFO  SingleTableSplitUtil - split pk [sql=SELECT MIN(id),MAX(id) FROM user] is running...
2020-05-05 20:35:42.783 [job-0] INFO  SingleTableSplitUtil - After split(), allQuerySql=[
select id,user_name,create_time from user  where  (6866 <= id AND id < 12866)
select id,user_name,create_time from user  where  (12866 <= id AND id < 18866)
select id,user_name,create_time from user  where  (18866 <= id AND id < 24866)
select id,user_name,create_time from user  where  (24866 <= id AND id < 30866)
select id,user_name,create_time from user  where  (30866 <= id AND id < 36866)
select id,user_name,create_time from user  where  (36866 <= id AND id < 42866)
select id,user_name,create_time from user  where  (42866 <= id AND id < 48866)
select id,user_name,create_time from user  where  (48866 <= id AND id < 54866)
select id,user_name,create_time from user  where  (54866 <= id AND id < 60866)
select id,user_name,create_time from user  where  (60866 <= id AND id < 66866)
select id,user_name,create_time from user  where  (66866 <= id AND id < 72866)
select id,user_name,create_time from user  where  (72866 <= id AND id < 78866)
select id,user_name,create_time from user  where  (78866 <= id AND id < 84866)
select id,user_name,create_time from user  where  (84866 <= id AND id < 90866)
select id,user_name,create_time from user  where  (90866 <= id AND id <= 96866)
select id,user_name,create_time from user  where  id IS NULL
].
2020-05-05 20:35:42.783 [job-0] INFO  JobContainer - DataX Reader.Job [mysqlreader] splits to [16] tasks.
2020-05-05 20:35:42.787 [job-0] INFO  JobContainer - DataX Writer.Job [mysqlwriter] splits to [16] tasks.
2020-05-05 20:35:42.857 [job-0] INFO  JobContainer - jobContainer starts to do schedule ...
2020-05-05 20:35:42.880 [job-0] INFO  JobContainer - Scheduler starts [1] taskGroups.
2020-05-05 20:35:42.881 [job-0] INFO  JobContainer - Running by standalone Mode.
2020-05-05 20:35:42.919 [taskGroup-0] INFO  TaskGroupContainer - taskGroupId=[0] start [3] channels for [16] tasks.
2020-05-05 20:35:42.922 [taskGroup-0] INFO  Channel - Channel set byte_speed_limit to -1, No bps activated.
2020-05-05 20:35:42.923 [taskGroup-0] INFO  Channel - Channel set record_speed_limit to -1, No tps activated.
2020-05-05 20:35:42.976 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[0] attemptCount[1] is started
2020-05-05 20:35:42.987 [0-0-0-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (6866 <= id AND id < 12866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:43.036 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[1] attemptCount[1] is started
2020-05-05 20:35:43.055 [0-0-1-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (12866 <= id AND id < 18866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:43.106 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[2] attemptCount[1] is started
2020-05-05 20:35:43.117 [0-0-2-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (18866 <= id AND id < 24866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:43.873 [0-0-1-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (12866 <= id AND id < 18866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:43.876 [0-0-0-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (6866 <= id AND id < 12866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:43.892 [0-0-2-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (18866 <= id AND id < 24866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:44.062 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[0] is successed, used[1121]ms
2020-05-05 20:35:44.063 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[1] is successed, used[1086]ms
2020-05-05 20:35:44.063 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[2] is successed, used[1024]ms
2020-05-05 20:35:44.105 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[3] attemptCount[1] is started
2020-05-05 20:35:44.112 [0-0-3-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (24866 <= id AND id < 30866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:44.157 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[4] attemptCount[1] is started
2020-05-05 20:35:44.163 [0-0-4-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (30866 <= id AND id < 36866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:44.204 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[5] attemptCount[1] is started
2020-05-05 20:35:44.205 [0-0-5-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (36866 <= id AND id < 42866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:45.049 [0-0-4-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (30866 <= id AND id < 36866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:45.134 [0-0-3-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (24866 <= id AND id < 30866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:45.136 [0-0-5-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (36866 <= id AND id < 42866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:45.225 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[4] is successed, used[1118]ms
2020-05-05 20:35:45.297 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[6] attemptCount[1] is started
2020-05-05 20:35:45.390 [0-0-6-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (42866 <= id AND id < 48866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:45.511 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[3] is successed, used[1447]ms
2020-05-05 20:35:45.511 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[5] is successed, used[1352]ms
2020-05-05 20:35:45.601 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[7] attemptCount[1] is started
2020-05-05 20:35:45.624 [0-0-7-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (48866 <= id AND id < 54866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:45.645 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[8] attemptCount[1] is started
2020-05-05 20:35:45.793 [0-0-8-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (54866 <= id AND id < 60866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:46.191 [0-0-6-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (42866 <= id AND id < 48866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:46.501 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[6] is successed, used[1264]ms
2020-05-05 20:35:46.650 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[9] attemptCount[1] is started
2020-05-05 20:35:46.712 [0-0-8-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (54866 <= id AND id < 60866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:46.814 [0-0-9-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (60866 <= id AND id < 66866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.079 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[8] is successed, used[1477]ms
2020-05-05 20:35:47.084 [0-0-7-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (48866 <= id AND id < 54866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.123 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[10] attemptCount[1] is started
2020-05-05 20:35:47.344 [0-0-10-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (66866 <= id AND id < 72866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.575 [0-0-9-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (60866 <= id AND id < 66866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.590 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[7] is successed, used[2035]ms
2020-05-05 20:35:47.635 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[11] attemptCount[1] is started
2020-05-05 20:35:47.663 [0-0-11-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (72866 <= id AND id < 78866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.745 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[9] is successed, used[1139]ms
2020-05-05 20:35:47.762 [0-0-10-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (66866 <= id AND id < 72866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.814 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[12] attemptCount[1] is started
2020-05-05 20:35:47.823 [0-0-12-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (78866 <= id AND id < 84866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.874 [0-0-11-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (72866 <= id AND id < 78866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.915 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[10] is successed, used[834]ms
2020-05-05 20:35:47.957 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[13] attemptCount[1] is started
2020-05-05 20:35:47.973 [0-0-12-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (78866 <= id AND id < 84866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:47.974 [0-0-13-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (84866 <= id AND id < 90866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:48.067 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[11] is successed, used[477]ms
2020-05-05 20:35:48.067 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[12] is successed, used[321]ms
2020-05-05 20:35:48.113 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[14] attemptCount[1] is started
2020-05-05 20:35:48.122 [0-0-13-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (84866 <= id AND id < 90866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:48.123 [0-0-14-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  (90866 <= id AND id <= 96866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:48.161 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[15] attemptCount[1] is started
2020-05-05 20:35:48.163 [0-0-15-reader] INFO  CommonRdbmsReader$Task - Begin to read record by Sql: [select id,user_name,create_time from user  where  id IS NULL
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:48.238 [0-0-15-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  id IS NULL
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:48.262 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[13] is successed, used[345]ms
2020-05-05 20:35:48.262 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[15] is successed, used[147]ms
2020-05-05 20:35:48.304 [0-0-14-reader] INFO  CommonRdbmsReader$Task - Finished read record by Sql: [select id,user_name,create_time from user  where  (90866 <= id AND id <= 96866)
] jdbcUrl:[jdbc:mysql://192.168.199.201:3307/test?yearIsDateType=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&rewriteBatchedStatements=true].
2020-05-05 20:35:48.471 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] taskId[14] is successed, used[403]ms
2020-05-05 20:35:48.472 [taskGroup-0] INFO  TaskGroupContainer - taskGroup[0] completed it's tasks.
2020-05-05 20:35:52.938 [job-0] INFO  StandAloneJobContainerCommunicator - Total 90001 records, 1616885 bytes | Speed 157.90KB/s, 9000 records/s | Error 0 records, 0 bytes |  All Task WaitWriterTime 7.155s |  All Task WaitReaderTime 3.036s | Percentage 100.00%
2020-05-05 20:35:52.938 [job-0] INFO  AbstractScheduler - Scheduler accomplished all tasks.
2020-05-05 20:35:52.938 [job-0] INFO  JobContainer - DataX Writer.Job [mysqlwriter] do post work.
2020-05-05 20:35:52.939 [job-0] INFO  JobContainer - DataX Reader.Job [mysqlreader] do post work.
2020-05-05 20:35:52.939 [job-0] INFO  JobContainer - DataX jobId [0] completed successfully.
2020-05-05 20:35:52.939 [job-0] INFO  HookInvoker - No hook invoked, because base dir not exists or is a file: /root/datax/hook
2020-05-05 20:35:52.940 [job-0] INFO  JobContainer -
         [total cpu info] =>
                averageCpu                     | maxDeltaCpu                    | minDeltaCpu
                -1.00%                         | -1.00%                         | -1.00%


         [total gc info] =>
                 NAME                 | totalGCCount       | maxDeltaGCCount    | minDeltaGCCount    | totalGCTime        | maxDeltaGCTime     | minDeltaGCTime
                 Copy                 | 1                  | 1                  | 1                  | 0.166s             | 0.166s             | 0.166s
                 MarkSweepCompact     | 0                  | 0                  | 0                  | 0.000s             | 0.000s             | 0.000s

2020-05-05 20:35:52.940 [job-0] INFO  JobContainer - PerfTrace not enable!
2020-05-05 20:35:52.940 [job-0] INFO  StandAloneJobContainerCommunicator - Total 90001 records, 1616885 bytes | Speed 157.90KB/s, 9000 records/s | Error 0 records, 0 bytes |  All Task WaitWriterTime 7.155s |  All Task WaitReaderTime 3.036s | Percentage 100.00%
2020-05-05 20:35:52.941 [job-0] INFO  JobContainer -
任务启动时刻                    : 2020-05-05 20:35:41
任务结束时刻                    : 2020-05-05 20:35:52
任务总计耗时                    :                 11s
任务平均流量                    :          157.90KB/s
记录写入速度                    :           9000rec/s
读出记录总数                    :               90001
读写失败总数                    :                   0

[root@localhost datax]#
```
