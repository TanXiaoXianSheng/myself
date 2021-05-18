package javaClass;

import org.junit.Test;

import java.lang.reflect.Field;
import java.rmi.Naming;
import java.rmi.registry.Registry;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/16 11:19 上午
 */
public class ClassTest {

    @Test
    public void test001(){
        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        int a = 1;
    }

    @Test
    public <T> void test002(){
        Class<T> userClass = (Class<T>) User.class;
        Class<?> superclass = userClass.getSuperclass();
        int a = 1;

        Naming naming = null;
        Registry registry;
    }

    @Test
    public <T> void test003() throws IllegalAccessException {
        User user = new User(1, "张三");

        Class<T> userClass = (Class<T>) User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            field.set(field, field.get(user));
        }
        int a = 1;
    }

}
