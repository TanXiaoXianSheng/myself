# 建造者模式 / 原型模式 / 链式构造

参考：
1. [Java设计模式之建造者模式(原型/链式)](https://www.jianshu.com/p/8e871becd9cf?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation)
**重点摘要**：(相比于普通JavaBean的好处)：
   在建造者模式中,提供一个辅助的静态建造器Builder(静态内部类),可以在里面set实体类的属性,与JavaBean不同的是,建造者是先set,在通过build实例化实体类,这样既可以提高代码的阅读性,也可以防止对象没有实例化,就被调用;不会造成不一致性,同时解决了Javabean模式的线程安全问题
   [代码地址](./_001)