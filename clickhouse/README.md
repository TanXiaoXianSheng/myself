clickhouse
==

# 整体介绍
# 安装
[安装](www.baidu.com)
# hive,es比较
# 支持字段
1. 整数

    带或不带符号的指定长度整数

    *有符号*
* Int8 - [-128 : 127]
* Int16 - [-32768 : 32767]
* Int32 - [-2147483648 : 2147483647]
* Int64 - [-9223372036854775808 : 9223372036854775807]

  *无符号*
* UInt8 - [0 : 255]
* UInt16 - [0 : 65535]
* UInt32 - [0 : 4294967295]
* UInt64 - [0 : 18446744073709551615]
1. 浮点数

    浮点数和C语言中的相同，clickhouse中建议尽量用整数，因为用浮点数计算可能会出现舍入误差
  
1. Decimal(P,S)

    这个没太看懂
  
1. boolean

    没有boolean操作符，用的是Uint8类型，只是把数字限制成了0,1
  
1. String

    String 的长度不受限制，可以为任意长度，它的值也可以为任意值，包括空值。这里用String替代了其它 DBMS 中的 varchar,blob,clob和其它的字符串类型
    
    clickhouse 没有指定的编码格式，你存入什么编码，取出就是什么编码。如果存入文本，clickhouse建议用utf-8。（后面还有一些，没看懂）

1. FixedString

    固定 N 个字节的String，N是自然数
    
    `<column_name> FixedString(N)`
    
1. UUID

    通用惟一标识符(UUID)是一个16字节的数字，用于标识记录。有关UUID的详细信息，请参见[Wikipedia](https://en.wikipedia.org/wiki/Universally_unique_identifier)
    
    UUID例子：`61f0c404-5cb3-11e7-907b-a6006ad3dba0`
    
    插入第一条数据：`00000000-0000-0000-0000-000000000000`
    
    *这两个例子我翻译的好像有问题，欢迎指出*
    
    UUID的生成规则，clickhouse提供了[generateUUIDv4](https://clickhouse.yandex/docs/en/query_language/functions/uuid_functions/)函数
    
    UUID只支持Stirng类型支持的函数，例如min,max,count，不支持算术操作，例如sum,avg
    
1. Date
    
    日期，存放在2个字节中，放的是从1970-01-01到每天的天数（后面还有解释，没看懂）
    
    表现形式：`0000-00-00`
    
    date存储没有时区之分
    
1. DateTime

    日期和时间，4个字节，存放时间从1970-01-01开始
    
    表现形式： `0000-00-00 00:00:00`，精度为秒
    
    有时区
    
    在生成dataTime的时候，默认按设备当时在的时区分配，当dataTime存储的时候，时区特征以已消失不见，我们也可以自定义时区，通过启用客户机命令行选项`——use_client_time_zone`来更改此行为
    
1. Enum8,Enum16
    
    包括Enum8和Enum16两种类型，存储着'String' = Integer的有限键值对集。在clickhouse中，操作的时候，把所有的value都看作Integer来操作，尽管有时候是Stirng类型，官方说这样更高效
    
    * Enum8 ==> 'String' = Int8
    * Enum16 => 'String' = Int16
    
    (补上操作图)
    
    一般规则及用法（太长了，还没看）

1. Array(T)

    T类型数据的数组
    
    当创建一个动态数组时，clickhouse自动将数组参数类型定义为它所存储元素的最窄类型（就是如果同时有int和float,取float），如果有任何null和Nullable类型的参数，数组类型就为Nullable
    
    如果clickhouse不能决定是哪一种类型，就会报异常，例如 `select Array(1,'a')`
    
1. AggregateFunction(name,types_of_arguments...)
   
   （这个太高级，我看不懂，后面补充）
    
1. Tuple(T1,T2,...)

    元素的元组，每个元素都有一个单独的类型。
不能将元组存储在表中(内存表除外)。它们用于临时列分组。当在查询中使用IN表达式以及指定lambda函数的某些形式参数时，可以对列进行分组。有关更多信息，请参见操作符和高阶函数部分。
元组可以是查询的结果。在本例中，对于JSON之外的文本格式，值在括号中以逗号分隔。在JSON格式中，元组作为数组输出(在方括号中)。

    感觉这个和Array(T)比较像，不同之处在于可以存储不同类型的数据
    
1. Nullable(TypeName)

    允许使用null来标记没有值，例如一个`Nullable(Int8)`类型的列可以用来存储int8的数据，也可以存储NULL
    
    Nullable不可以用于索引
    
    Null是Nullable类型的默认值，可以通过修改clickhouse的配置进行修改
    
    官方不推荐使用Nullable
    
1. Nested(Name1 Type1,Name2 Type2,...)

    嵌套数据结构类型
    
    ```
    CREATE TABLE test.visits
    (
        CounterID UInt32,
        StartDate Date,
        Sign Int8,
        IsNew UInt8,
        VisitID UInt64,
        UserID UInt64,
        ...
        Goals Nested
        (
            ID UInt32,
            Serial UInt32,
            EventTime DateTime,
            Price Int64,
            OrderID String,
            CurrencyID UInt32
        ),
        ...
        ) ENGINE = CollapsingMergeTree(StartDate, intHash32(UserID), (CounterID, StartDate, intHash32(UserID), VisitID), 8192, Sign)
    ```
    
    （进一步解释以后补充）
    
1. Special Data Types
   
    * Expression：用于表示高阶函数的lambda表达式
    
    * Set: 用于表达式的左边部分
    
    * Nothing: （不太明白，后面补充）
# sql操作
##  1. create
##  2. insert
##  3. alert
##  4. select
# 上传数据
# 注意事项
# 优缺点
