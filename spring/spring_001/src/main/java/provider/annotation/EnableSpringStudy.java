package provider.annotation;

import provider.config.SpringStudySelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/16 2:19 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(SpringStudySelector.class)
public @interface EnableSpringStudy {
}
