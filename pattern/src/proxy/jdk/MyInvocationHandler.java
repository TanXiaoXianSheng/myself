package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/11 15:02
 **/
public class MyInvocationHandler implements InvocationHandler {

    Subject realSubject;

    public MyInvocationHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    /**
     *
     * @param proxy: 动态代理对象
     * @param method：正在执行的方法
     * @param args： 调用目标方法时传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        if (method.getName().equalsIgnoreCase("sellBooks")){
            int invoke = (int)method.invoke(realSubject,args);
            return invoke;
        }else {
            String invoke = (String)method.invoke(realSubject,args);
            return invoke;

        }
    }
}
