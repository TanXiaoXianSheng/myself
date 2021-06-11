package cn.bcf.springboot.config;

import cn.bcf.springboot.typeHandler.ConfigurationHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/11 5:13 下午
 */
@Configuration
@ConditionalOnClass(Init.class)
@Component("myConfig")
public class MyConfig {

    @Autowired
    private ApplicationContext appContext;

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    public Init init() throws ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        ConfigurationHelper.loadEnumHandler(sqlSessionFactory);
        System.out.println("001111111 " + sqlSessionFactory);
        return new Init();
    }

}
