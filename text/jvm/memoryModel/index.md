#  JVM内存模型
参考：  
1. [Java8移除永久代](https://blog.csdn.net/aa747604141/article/details/52673582)

### 内存模型

![图-01](./image/model.png 'Hotspot 1.8 内存模型')

程序计数器：相当于操作系统的寄存器，不会OOM

本地方法栈：调用非本地方法使用

虚拟机栈：线程栈，一个线程一个，linux x64默认1M，`-xss1024k`，存放基本类型数据，对象引用

类元数据：jdk 1.7之前存放在jvm内存方法区（永久代）中，后方法区取消，类元数据分到物理内存，字符串常量池和类常量放到堆中

堆(heap)：存放对象，公用(有特殊)，GC（garbage collection）主要区域，堆内存 ≈ jvm内存。

### GC

![GC](./image/heap.png 'JVM heap概念图')

分代回收：young(新生代)、old(老年代)

##### 存活标准：

可达性分析：从起点（本地方法栈、虚拟机栈、字符串常量池、类变量、常量）开始向下遍历，经过的都是有资格活下来的

引用计数法：记录每一个对象正在被引用的次数

##### GC算法：

标记-清楚算法：old区使用

复制算法：yound区使用

```
-Xms//初始内存
-Xmx//最大内存

-Xmn//young区大小
-XX:NewRatio=4//old/young = 4,old : young = 4
-XX:SurvivorRatio=8//eden/survivor = 8,eden : survivor : survivor = 8 : 1 : 1
```

