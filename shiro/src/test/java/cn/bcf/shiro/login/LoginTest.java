package cn.bcf.shiro.login;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 17:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    private Login login;

    @Test
    public void LoginTest(){
        login.login("classpath:shiro.ini","zhang","123");
    }

    @Test
    public void Realm01Test(){
        login.login("classpath:shiro-realm.ini","zhang","123");
    }

    @Test
    public void jdbcRealmTest(){
        login.login("classpath:shiro-jdbc-realm.ini","zhang","123");
    }

    @Test
    public void authorizerTest(){
        login.login("classpath:shiro-jdbc-realm02.ini","zhang","123");
        //判断拥有权限：user:create
        System.out.println(Base.getSubject().isPermitted("user1:update"));
        System.out.println(Base.getSubject().isPermitted("user2:update"));
        //通过二进制位的方式表示权限
        System.out.println(Base.getSubject().isPermitted("+user1+2"));//新增权限
        System.out.println(Base.getSubject().isPermitted("+user1+8"));//查看权限
        System.out.println(Base.getSubject().isPermitted("+user2+10"));//新增及查看
        System.out.println(Base.getSubject().isPermitted("+user1+4"));//没有删除权限
        System.out.println(Base.getSubject().isPermitted("menu:view"));//通过
    }
}
