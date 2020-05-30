DataX的参数配置由三部分组成，用户自定义json、core.json、程序中默认  
优先级：自定义json > core.json > 程序中默认  
个人感觉core.json在阿里内部版本并不存在，是为了开源方便上手而提取出来的，也可以直接把core.json删除，不影响程序运行

参数|解释
:-|:-
core.container.job.id|local和单机都为-1，分布式时大于1，必填
core.container.job.mode|运行模式，有两种：standalone，taskGroup，必填
core.container.job.reportInterval|不清楚，状态汇报时间间隔，稍长，避免大量汇报，默认10000
core.container.taskGroup.channel|每个taskGroup中并发的最大数量，默认为5
core.container.trace.enable|不清楚，应该是是否统计追踪JVM的，默认false
core.dataXServer.address|
core.dataXServer.timeout|
core.dataXServer.reportDataxLog|
core.dataXServer.reportPerfLog|
core.statistics.collector.plugin.taskClass|
core.statistics.collector.plugin.maxDirtyNumber|
core.transport.channel.class|channel实现类
core.transport.channel.speed.byte|根据字节对channel进行限流，默认-1，程序默认1024*1024
core.transport.channel.speed.record|根据记录数限流，默认-1，程序默认10000
core.transport.channel.flowControlInterval|不清楚，默认20，程序默认1000
core.transport.channel.capacity|不清楚，默认512，程序默认2048
core.transport.exchanger.class|不清楚
core.transport.exchanger.bufferSize|不清楚，默认32
entry.jvm|没有实际意义，应该是想在配置中放入JVM的启动配置信息，但在core.json中写死了，为-Xms1G -Xmx1G，和实际不符合
job.content[0].reader.name|reader插件name，固定值，大小写要求
job.content[0].reader.parameter.connection[0].jdbcUrl[0]|数据库url
job.content[0].reader.parameter.connection[0].table[0]|数据库表
job.content[0].reader.parameter.connection[0].querySql[*]|querySql模式，配置querySql时，reader直接忽略table、column、where条件的配置
job.content[0].reader.parameter.username|数据库用户名
job.content[0].reader.parameter.password|数据库密码（又看到支持动态输入，待确认）
job.content[0].reader.parameter.splitPk|切分主键，支持数字和字符串（数字形式的字符串，程序中转化为了Long:待确认
job.content[0].reader.parameter.column[*]|要读取的列名
job.content[0].reader.parameter.isTableMode|判断reader是querySql语句模式还是表字段模式，true:表模式，false:querySql模式
job.content[0].writer.name|writer插件name，固定值，大小写要求
job.content[0].writer.parameter.writeMode|写入模式，insert、replace、update，默认insert
job.content[0].writer.parameter.connection[0].jdbcUrl|写入数据库url
job.content[0].writer.parameter.connection[0].table[0]|写入表名
job.content[0].writer.parameter.username|数据库用户名
job.content[0].writer.parameter.password|数据库密码
job.content[0].writer.parameter.preSql[0]|写入前预处理语句，比如清空写入表，sql
job.content[0].writer.parameter.column[*]|写入列
job.setting.errorLimit.percentage|job容忍的错误率，百分比，默认0.02
job.setting.errorLimit.record|jon容忍错误率，条数，默认0，和百分比的哪个占主要，待确认
job.setting.speed.channel|并发通道数，并发task数
job.setting.speed.byte|字节流控模式，所有通道字节流总和
job.setting.speed.record|记录流模式，所有通道记录总和
common.column.extraFormats[0]|默认yyyyMMdd，应该是列转换时候对事件的处理，待研究
common.column.timeFormat|默认HH:mm:ss
common.column.timeZone|默认GMT+8
common.column.dateFormat|默认yyyy-MM-dd
common.column.datetimeFormat|默认yyyy-MM-dd HH:mm:ss
common.column.encoding|默认utf-8

```
{
	"common": {
		"column": {
			"dateFormat": "yyyy-MM-dd",
			"datetimeFormat": "yyyy-MM-dd HH:mm:ss",
			"encoding": "utf-8",
			"extraFormats": ["yyyyMMdd"],
			"timeFormat": "HH:mm:ss",
			"timeZone": "GMT+8"
		}
	},
	"core": {
		"container": {
			"job": {
				"id": -1,
				"mode": "standalone",
				"reportInterval": 10000
			},
			"taskGroup": {
				"channel": 5
			},
			"trace": {
				"enable": "false"
			}
		},
		"dataXServer": {
			"address": "http://localhost:7001/api",
			"reportDataxLog": false,
			"reportPerfLog": false,
			"timeout": 10000
		},
		"statistics": {
			"collector": {
				"plugin": {
					"maxDirtyNumber": 10,
					"taskClass": "com.alibaba.datax.core.statistics.plugin.task.StdoutPluginCollector"
				}
			}
		},
		"transport": {
			"channel": {
				"byteCapacity": 67108864,
				"capacity": 512,
				"class": "com.alibaba.datax.core.transport.channel.memory.MemoryChannel",
				"flowControlInterval": 20,
				"speed": {
					"byte": -1,
					"record": -1
				}
			},
			"exchanger": {
				"bufferSize": 32,
				"class": "com.alibaba.datax.core.plugin.BufferedRecordExchanger"
			}
		}
	},
	"entry": {
		"jvm": "-Xms1G -Xmx1G"
	},
	"job": {
		"content": [{
			"reader": {
				"name": "mysqlreader",
				"parameter": {
					"column": ["id", "user_name", "create_time"],
					"connection": [{
						"jdbcUrl": ["jdbc:mysql://192.168.199.201:3307/test"],
						"table": ["user"]
					}],
					"password": "1226",
					"splitPk": "id",
					"username": "root"
				}
			},
			"writer": {
				"name": "mysqlwriter",
				"parameter": {
					"column": ["id", "user_name", "create_time"],
					"connection": [{
						"jdbcUrl": "jdbc:mysql://192.168.199.201:3306/test?useUnicode=true&characterEncoding=utf8",
						"table": ["user"]
					}],
					"password": "1226",
					"preSql": ["delete from user"],
					"session": [],
					"username": "root",
					"writeMode": "insert"
				}
			}
		}],
		"setting": {
			"errorLimit": {
				"percentage": 0.02,
				"record": 0
			},
			"speed": {
				"channel": 3
			}
		}
	},
	"plugin": {
		"reader": {
			"mysqlreader": {
				"class": "com.alibaba.datax.plugin.reader.mysqlreader.MysqlReader",
				"description": "useScene: prod. mechanism: Jdbc connection using the database, execute select sql, retrieve data from the ResultSet. warn: The more you know about the database, the less problems you encounter.",
				"developer": "alibaba",
				"name": "mysqlreader",
				"path": "D:\\own\\openSource\\DataX\\core\\src\\main\\plugin\reader\\mysqlreader"
			}
		},
		"writer": {
			"mysqlwriter": {
				"class": "com.alibaba.datax.plugin.writer.mysqlwriter.MysqlWriter",
				"description": "useScene: prod. mechanism: Jdbc connection using the database, execute insert sql. warn: The more you know about the database, the less problems you encounter.",
				"developer": "alibaba",
				"name": "mysqlwriter",
				"path": "D:\\own\\openSource\\DataX\\core\\src\\main\\plugin\\writer\\mysqlwriter"
			}
		}
	}
}
```
