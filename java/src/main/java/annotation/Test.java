package annotation;

import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/7 6:45 下午
 */
@IndexAnnotated
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

    String key() default "key";

}
