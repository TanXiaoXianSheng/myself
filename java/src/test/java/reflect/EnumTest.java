package reflect;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/27 8:50 下午
 */
public class EnumTest {

    Class clazz;

    @Before
    public void before() {
        clazz = SexEnum.class;
        SexEnum.MAN.name();
    }

    @Test
    public void test001() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = clazz.getMethod("values");
        Object enums = null;
        if (method != null) {
            enums = method.invoke(null);
        }
        System.out.println(JSON.toJSONString(enums));
        int a = 1;
    }

    @Test
    public void test002() {
        Object[] enums = clazz.getEnumConstants();
        System.out.println(JSON.toJSONString(enums));
    }

}
