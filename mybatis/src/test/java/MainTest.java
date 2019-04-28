import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/23 18:16
 **/
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
}
