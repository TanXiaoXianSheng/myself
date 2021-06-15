package cn.bcf.mybatis;

import cn.bcf.mybatis.entity.UserEntity;
import cn.bcf.mybatis.service.UserService;
import cn.bcf.mybatis.typeHandler.ConfigurationHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ApplicationContext appContext;

    @Autowired(required = false)
    UserService userService;

    @Test
    public void test001() {
        List<UserEntity> list = userService.selectAll();
        list.stream().forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void test002() {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans)
        {
            System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
        }
    }

    @Test
    public void test003() throws ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        int a = 1;
    }

    @Test
    public void test004() throws ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        ConfigurationHelper.loadEnumHandler(sqlSessionFactory);

        List<UserEntity> list = userService.selectAll();
        list.stream().forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void test005() throws ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)appContext.getBean("sqlSessionFactory");
        //ConfigurationHelper.loadEnumHandler(sqlSessionFactory);
        List<UserEntity> list = userService.selectAll();
        list.stream().forEach(x -> System.out.println(x.toString()));
    }

}
