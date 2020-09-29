# Mybatis

参考：  

1. [聊聊MyBatis缓存机制](https://tech.meituan.com/2018/01/19/mybatis-cache.html)

一级缓存，默认开启，sqlSession作用域，会出现脏数据

二级缓存，手动开启，作用域范围是xml中的namespace，同一个namespace内查询没问题，跨namespace会出现脏数据

1. 测试二级缓存效果，不提交事务，`sqlSession1`查询完数据后，`sqlSession2`相同的查询是否会从缓存中获取数据。

     不能

2. 测试二级缓存效果，当提交事务时，`sqlSession1`查询完数据后，`sqlSession2`相同的查询是否会从缓存中获取数据。

     能

3. 测试`update`操作是否会刷新该`namespace`下的二级缓存。

     会

4. 验证MyBatis的二级缓存不适应用于映射文件中存在多表查询的情况。  
     通常我们会为每个单表创建单独的映射文件，由于MyBatis的二级缓存是基于namespace的，多表查询语句所在的namspace无法感应到其他namespace中的语句对多表查询中涉及的表进行的修改，引发脏数据问题

     为解决问题，可以使用Cache ref，让`ClassMapper`引用`StudenMapper`命名空间，这样两个映射文件对应的SQL操作都使用的是同一块缓存了。
