import entity.UserEntity;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

public class Mybatis002 {

    public static SqlSession session;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        session = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void test001() {
        List<UserEntity> userList = session.selectOne("mapper.UserMapper.selectAll");
        out.println(userList);
    }
}
