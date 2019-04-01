package myself;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyselfApplicationTests {

    @Test
    public void contextLoads() {
        Executors executors = (Executors) Executors.newScheduledThreadPool(5);
    }

    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    @Test
    public void testMD5(){
        String s = "{\n" +
                "  \"db\": {\n" +
                "    \"type\": \"hbase\",\n" +
                "    \"table\": \"jr_dwservice:task_time_detail\"\n" +
                "  },\n" +
                "  \"message\": {\n" +
                "    \"row\": \"aaa\",\n" +
                "    \"fimalys\": [{\n" +
                "      \"fimaly\": \"info\",\n" +
                "      \"element\": {\n" +
                "        \"name\": \"zhangsan002\",\n" +
                "        \"age\": 20,\n" +
                "        \"sex\": \"male\"\n" +
                "      }\n" +
                "    },{\n" +
                "      \"fimaly\": \"extra\",\n" +
                "      \"element\": {\n" +
                "        \"today\": \"2019/3/14\",\n" +
                "        \"weather\": \"sunshine\"\n" +
                "      }\n" +
                "    }]\n" +
                "\n" +
                "\n" +
                "  }\n" +
                "}\n";

        System.out.println("original:" + s);

        System.out.println("MD5:" + string2MD5(s));

        System.out.println("convert:" + convertMD5(s));

        System.out.println("convertAfter:" + convertMD5(convertMD5(s)));

        System.out.println("original:" + s);

        System.out.println("MD5:" + string2MD5(s));

        System.out.println("convert:" + convertMD5(s));

        System.out.println("convertAfter:" + convertMD5(convertMD5(s)));
    }

    @Test
    public void URLEncoder() throws UnsupportedEncodingException {
        String str = URLEncoder.encode( "{\n" +
                "  \"db\": {\n" +
                "    \"type\": \"hbase\",\n" +
                "    \"name\": \"jr_dwservice:task_time_detail\",\n" +
                "    \"table\": \"jr_dwservice:task_time_detail\"\n" +
                "  },\n" +
                "  \"connection\": {\n" +
                "    \"username\": \"root\",\n" +
                "    \"password\": \"root\",\n" +
                "    \"url\": \"url\"\n" +
                "  },\n" +
                "  \"message\": {\n" +
                "    \"row\": \"01\",\n" +
                "    \"fimalys\": [{\n" +
                "      \"fimaly\": \"info\",\n" +
                "      \"element\": {\n" +
                "        \"name\": \"zhangsan002\",\n" +
                "        \"age\": 20,\n" +
                "        \"sex\": \"male\"\n" +
                "      }\n" +
                "    }]\n" +
                "\n" +
                "\n" +
                "  }\n" +
                "}", "UTF-8" );
        System.out.println(str);
    }

    @Test
    public void URL() throws UnsupportedEncodingException{
        String str = URLDecoder.decode( "%7B%0A++%22db%22%3A+%7B%0A++++%22type%22%3A+%22hbase%22%2C%0A++++%22name%22%3A+%22jr_dwservice%3Atask_time_detail%22%2C%0A++++%22table%22%3A+%22jr_dwservice%3Atask_time_detail%22%0A++%7D%2C%0A++%22connection%22%3A+%7B%0A++++%22username%22%3A+%22root%22%2C%0A++++%22password%22%3A+%22root%22%2C%0A++++%22url%22%3A+%22url%22%0A++%7D%2C%0A++%22message%22%3A+%7B%0A++++%22row%22%3A+%2201%22%2C%0A++++%22fimalys%22%3A+%5B%7B%0A++++++%22fimaly%22%3A+%22info%22%2C%0A++++++%22element%22%3A+%7B%0A++++++++%22name%22%3A+%22zhangsan002%22%2C%0A++++++++%22age%22%3A+20%2C%0A++++++++%22sex%22%3A+%22male%22%0A++++++%7D%0A++++%7D%5D%0A%0A%0A++%7D%0A%7D", "UTF-8" );
        System.out.println(str);
    }



}

