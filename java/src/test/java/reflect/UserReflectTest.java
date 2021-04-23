package reflect;

import com.alibaba.fastjson.JSON;
import com.gitee.easyopen.doc.ApiDocFieldDefinition;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.*;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/20 7:32 下午
 */
public class UserReflectTest {

    Class<?> clazz;

    @Before
    public void before() {
        clazz = User.class;
    }

    @Test
    public void test001() {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        long count = Arrays.asList(constructors).stream().filter(x -> x.getParameterTypes().length == 0).count();
        int a = 1;
    }

    @Test
    public void test002() {
        Method[] methodArr = clazz.getMethods();
        Arrays.asList(methodArr).stream().forEach(x -> out.println(x.getName()));
        int a = 1;
    }

    @Test
    public void test003() {
        Method[] methodArr = clazz.getDeclaredMethods();
        Arrays.asList(methodArr).stream().forEach(x -> out.println(x.getName()));
        methodArr[0].isBridge();
        Class<?>[] interfaceArr = clazz.getInterfaces();
        out.println("----------------");
        Arrays.asList(interfaceArr).stream().forEach(x -> out.println(x.getName()));
        out.println("----------------");
        for (Class<?> anInterface : interfaceArr) {
            Method[] methodArrTemp = anInterface.getMethods();
            Arrays.asList(methodArrTemp).stream().forEach(x -> out.println(x.getName()));
        }
    }

    @Test
    public void test004() {
        AnnotatedType[] annotatedTypeArr = clazz.getAnnotatedInterfaces();
        Arrays.asList(annotatedTypeArr).stream().forEach(x -> out.println(x.getType()));
        Annotation[] annotationArr = clazz.getAnnotations();
        Arrays.asList(annotationArr).stream().forEach(x -> out.println(x.toString()));
    }

    @Test
    public void test005() {
        Field[] fieldArr = clazz.getFields();
        Map<String, Annotation[]> map = Arrays.asList(fieldArr).stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getAnnotations()));

        Field[] fieldArr02 = clazz.getDeclaredFields();
        Map<String, Annotation[]> map02 = Arrays.asList(fieldArr02).stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getAnnotations()));
        JSON.parseObject(JSON.toJSONString(map02.get("username")[0]), ApiDocFieldDefinition.class);
        int a = 1;
    }

    @Test
    public void test006() {
        Integer a = clazz.getModifiers();
        out.println(a);
        String str = Modifier.toString(a);
        out.println(str);
    }


}
