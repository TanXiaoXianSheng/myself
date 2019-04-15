# java小知识点

1. final不能有子类，abstract类的子类不必实现所有的abstract方法
2. Integer i = new Integer(12) 创建的是对象，不是基本类型
3. 继承中代码执行顺序，
    1. 父类静态
    2. 子类静态
    3. 父类非静态对象
    4. 父类构造
    4. 子类非静态对象
    5. 子类构造
1. byte,short计算时侯提升为int，用final修饰不会提升
