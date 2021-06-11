package date;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/9 10:32 上午
 */
public class Test001 {

    @Test
    public void test001() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.format(date);
    }

    @Test
    public void test002() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        Long longtimestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        int a = 1;
    }

    @Test
    public void test003() {
        LocalDate beginDateTime = LocalDate.parse("2021-08-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = beginDateTime.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        Long longtimestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        int a = 1;
    }

    @Test
    public void test004() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Long getMoneyTime = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        int a = 1;
    }

}
