# 疑问

1. 这三种都是在什么时候被初始化和赋值，在类加载中有什么不同？
```
final static int a = 1;
static int a = 1;
int a = 1;
```
1. 现在我们有一个项目--Hello，打成jar包，成功部署并正常运行，有一天我们要修改Test01.java(不包含内部类)，打算修改完编译后只把Hello.jar中的Test01.class进行替换，运行，这样是否可以？
	+ Test01.java中有`final`修饰的常量是否可以？
	+ Test01.java中不包含`final`修饰的常量是否可以？
2. 给出下面输出:
```
public class Parent {  
	public static String value = "123";  

	static {  
		System.out.println("parent");  
	}  
}  
```
```
public class Sub extends Parent {  

	static {  
		System.out.println("sub");  
	}  
}  
```
```
public class Main {  

	public static void main(String[] args) {  
		System.out.println(Sub.value);  
	}  
}  
```
Sub对象初始化了吗？Parent对象初始化了吗？
3. 
```
public interface Base {
	static int base = 1;
}
```
```
public class Parent implements Base {
	static int parent = 2;
}
```
```
public class Sub extends Parent {
	static int sub = 3;
}
```
	- `new Sub()`时，`base`,`parent`,`sub`，哪些会被赋值  
	- `Sub sub = new Sub();sub.base;`时，`base`,`parent`,`sub`，哪些会被赋值  