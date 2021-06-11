import com.alibaba.fastjson.JSON;
import entity.UserEntity;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import typeHandler.ConfigurationHelper;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/30 6:03 下午
 */
public class Mybatis001 {

    public static SqlSession session;

    @Before
    public void before() throws IOException, ClassNotFoundException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        ConfigurationHelper.loadEnumHandler(sqlSessionFactory);
        session = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void test003() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserEntity> list = mapper.selectAll();
        list.stream().forEach(x -> out.println(JSON.toJSONString(x)));
    }

}
