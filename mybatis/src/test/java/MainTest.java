import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/23 18:16
 **/
@SpringBootTest
public class MainTest {

    @Test
    public void getUserTest(){
        String resource = "conf.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statemen = "test.getUser";

        User user = session.selectOne(statemen,1);
        System.out.println(user);
    }

    @Test
    public void test002(){
        String resource = "conf.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("first:" + userMapper.getUserById(1));
        sqlSession.clearCache();
        System.out.println("second:" + userMapper.getUserById(1));
    }

    @Test
    public void test003(){
        String resource = "conf.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession01 = sessionFactory.openSession();
        UserMapper userMapper01 = sqlSession01.getMapper(UserMapper.class);
        System.out.println("first:" + userMapper01.getUserById(1));
        sqlSession01.close();

        SqlSession sqlSession02 = sessionFactory.openSession();
        UserMapper userMapper02 = sqlSession02.getMapper(UserMapper.class);
        System.out.println("second:" + userMapper02.getUserById(1));
        sqlSession01.close();

    }
}
