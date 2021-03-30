import com.alibaba.fastjson.JSON;
import entity.ReservationSearchQueryDto;
import mapper.PrdReservationMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Mybatis000 {

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
    public void test001() throws IOException {
        PrdReservationMapper mapper = session.getMapper(PrdReservationMapper.class);
        ReservationSearchQueryDto dto = new ReservationSearchQueryDto();
        dto.setStatus(0);
        List<Integer> statusList = new ArrayList<>();
        /*statusList.add(7);
        statusList.add(10);*/
        dto.setStatusList(statusList);
        List<Map<String, String>> map = mapper.select(dto);
        out.println(JSON.toJSONString(map));
    }

    @Test
    public void test002() {
        List<Map<String, String>> map = session.selectList("mapper.PrdReservationMapper.selectAll");
        out.println(JSON.toJSONString(map));
    }

}
