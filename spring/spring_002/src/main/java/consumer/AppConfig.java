package consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import provider.annotation.EnableSpringStudy;
import provider.bean.StudentBean;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/16 2:34 下午
 */
@EnableSpringStudy
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentBean studentBean = app.getBean(StudentBean.class);
        System.out.println(studentBean);
    }

}
