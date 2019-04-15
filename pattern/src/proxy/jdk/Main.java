package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/11 15:08
 **/
public class Main {

    public static void main(String[] args){
        Subject realSubject = new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);

        //Subject proxyClass = (Subject)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Subject.class},myInvocationHandler);
        Subject proxyClass = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(),new Class[]{Subject.class},myInvocationHandler);

        proxyClass.sellBooks();

        proxyClass.speak();
    }
}
