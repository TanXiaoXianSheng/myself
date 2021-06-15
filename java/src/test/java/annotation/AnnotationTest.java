package annotation;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/15 11:31 上午
 */
public class AnnotationTest {

    @Test
    public void test001() throws IOException {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources("/");
        int a = 1;
    }

    @Test
    public void test002() {
        Class clazz = annotation.Test.class;
        clazz.getAnnotations();
    }

}
