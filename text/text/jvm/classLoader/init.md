# 类加载--初始化
### 虚拟机规范严格规定有且只有5中情况必须对类进行“初始化”
1. 遇到new、getstatic、ptstatic、invokestatic 4条字节码指令时
   + 使用new
   + 读取或设置一个类的静态字段
   + 调用一个类的静态方法

2. 反射调用

3. 初始化一个类时，当父类未被初始化，需先初始化父类

4. 虚拟机启动，主类初始化（main()方法）

5. 当使用JDK 1.7的动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getStatic、REF_putStatic、REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有过初始化，则需要先触发其初始化。