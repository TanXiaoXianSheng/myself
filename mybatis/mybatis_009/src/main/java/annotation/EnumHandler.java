package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/8 6:53 下午
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumHandler {

    String key() default "key";

}
