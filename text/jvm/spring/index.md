# 一、生命周期

##### scope

- sigleton: 容器单例
- prototype: 一个bean请求一个
- request: 一个网络请求一个
- session: 一次会话一个
- global session: 只有在基于porlet的web应用中才有意义

##### 生命周期
Servlet的生命周期：实例化，初始init，接收请求service，销毁destroy

+ 实例化
+ 属性注入
+ 构造器
+ xxxAware接口，BeanNameAware、BeanFactoryAware、ApplicationContextAware
+ BeanPostProcesser.postProcesserBeforeInitalization(Object obj,String name)
+ init-method
+ BeanPostProcesser.postProcesserAfterInitalization(Object obj,String name)
+ 使用
+ 销毁：@PreDestroy > DisposableBean > destroy-method。只有singleton才有这一步

##### 线程安全

bean不是线程安全，可把singleton改为prototype

线程并发，加锁或者ThreadLocal

##### ben注入

注入：

- set
- 构造器
- 静态工厂
- 实例工厂

自动装配

- no
- byName
- byType
- constructor
- autodetect: 自动探测

@Autowired: 默认ByType，@Qualifier配合可以ByName

@Resource: 默认ByName，找不到ByType，J2EE提供

##### spring事务失效

1. 没有被spring管理
2. 方法不是Public
3. 自身方法调用
4. 非RuntimeException
5. 异常被try...catch...
6. 数据库引擎不支持