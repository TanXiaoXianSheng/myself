clickhouse
==

# 1. 整体介绍
# 2. hive,es比较
# 3. 支持字段
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


# 4. sql操作
##  1. create
##  2. insert
##  3. alert
##  4. select
# 5. 上传数据
# 6. 注意事项
# 7. 优缺点
