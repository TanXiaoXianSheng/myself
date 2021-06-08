package cn.bcf.mybatis;

import cn.bcf.mybatis.service.UserService;
import entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired(required = false)
    UserService userService;

    @Test
    public void test001() {
        List<UserEntity> list = userService.selectAll();
        list.stream().forEach(x -> System.out.println(x.toString()));
    }

}
