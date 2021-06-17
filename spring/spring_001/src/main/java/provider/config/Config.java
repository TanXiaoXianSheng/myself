package provider.config;

import provider.bean.StudentBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/16 2:20 下午
 */
@Configuration
public class Config {

    @Bean
    public StudentBean studentBean() {
        StudentBean studentBean = new StudentBean();
        studentBean.id = 19;
        studentBean.name = "zhangsan";
        return studentBean;
    }

}
