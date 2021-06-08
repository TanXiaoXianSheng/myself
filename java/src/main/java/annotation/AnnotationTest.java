package annotation;

import java.lang.annotation.Annotation;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/7 6:46 下午
 */
@Test
public class AnnotationTest {

    public static void main(String[] args) {
        Class clazz = SexEnum.class;
        Annotation[] annotations = clazz.getAnnotations();
        Annotation annotation = clazz.getAnnotation(Test.class);

        int a = 1;
    }
}
