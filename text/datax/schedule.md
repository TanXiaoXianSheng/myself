# Schedule解析

1. 限速是怎么达到的？  
wirte时决定，有record条数和字节大小两种，没有优先级，任何一个达到上限就写入

2. 内存空间多少？ 
这个问题更准确为read时数据放在内存中时，占用空间大小？ 
一个task默认分配64M内存，`core.transport.channel.byteCapacity`，供reader时作缓存使用，所以单条记录要小于64M(关系型数据库，其他暂未研究)

3. 错误率统计？  
错误率的统计也是在write阶段完成，task正常情况会根据限速条件来做批量写入，当批量错误时，就会做单条写入，同时会有个对象记录下错误记录和错误信息。

4. 怎么导出具体错误记录？  
后续增加。。。

4. 数据清洗怎么做？
开源版本没有清洗代码，也没有必要做。数据同步重要的是效率，最短的时间同步做多的数据才是王道，清洗可以在数据库层面做。
