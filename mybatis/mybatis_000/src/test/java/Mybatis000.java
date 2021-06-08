import com.alibaba.fastjson.JSON;
import entity.PrdResRepayEntity;
import entity.ReservationSearchQueryDto;
import enums.ReservationStatus;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        //dto.setStatus(0);
        List<Integer> statusList = new ArrayList<>();
        /*statusList.add(7);
        statusList.add(10);*/
        statusList.add(0);
        dto.setStatusList(statusList);
        //dto.setReservationNo("NPDC2099-202011180125101002104010007\n");
        String str = "{\"customerName\":\"校长\",\"deleted\":1,\"entId\":2099,\"statusList\":[]}";
        dto = JSON.parseObject(str, ReservationSearchQueryDto.class);
        List<Map<String, String>> map = mapper.select(dto);
        out.println(JSON.toJSONString(map));
    }

    @Test
    public void test002() {
        List<Map<String, String>> map = session.selectList("mapper.PrdReservationMapper.selectAll");
        out.println(JSON.toJSONString(map));
    }

    @Test
    public void test003() {
        PrdReservationMapper mapper = session.getMapper(PrdReservationMapper.class);


        List<Integer> statusList01 = new ArrayList<>();
        Integer count01 = mapper.selectCountByStatus(statusList01);

        List<Integer> statusList02 = new ArrayList<>();
        statusList02.add(ReservationStatus.TOBEACCEPTED.key);
        statusList02.add(ReservationStatus.ACCEPTING.key);
        statusList02.add(ReservationStatus.AUDITED.key);
        Integer count02 = mapper.selectCountByStatus(statusList02);

        List<Integer> statusList03 = new ArrayList<>();
        statusList03.add(ReservationStatus.CONFIRMACCOUNT.key);
        Integer count03 = mapper.selectCountByStatus(statusList03);

        List<Integer> statusList04 = new ArrayList<>();
        statusList04.add(ReservationStatus.SIGNED.key);
        statusList04.add(ReservationStatus.RECEIVING.key);
        statusList04.add(ReservationStatus.EXPIRED.key);
        Integer count04 = mapper.selectCountByStatus(statusList04);

        List<Integer> statusList05 = new ArrayList<>();
        statusList05.add(ReservationStatus.FAILED.key);
        Integer count05 = mapper.selectCountByStatus(statusList05);

        int a =  1;

    }

    @Test
    public void test004() {
        PrdReservationMapper mapper = session.getMapper(PrdReservationMapper.class);

        List<PrdResRepayEntity> list = mapper.selectByReserveId(5836);
        List<PrdResRepayEntity> repayEntityList = list.stream().filter(x -> x.getRepayNo().split("-")[1].equals(1)).collect(Collectors.toList());
        int a = 1;
    }

}
