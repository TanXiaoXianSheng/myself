package cn.bcf.mybatis.config;

import cn.bcf.mybatis.typeHandler.ConfigurationHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/11 5:13 下午
 */
@Configuration
@Component("myConfig")
public class MyConfig {

    @Autowired
    private ApplicationContext appContext;

    @PostConstruct
    public void init() throws ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        ConfigurationHelper.loadEnumHandler(sqlSessionFactory);
    }

}
