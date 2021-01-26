package match;

import com.newbanker.framework.httpclient.HttpUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void test001(){
        Pattern pattern = Pattern.compile("a");
        Matcher matcher = pattern.matcher("a");
        System.out.println(matcher.find());
    }

    @Test
    public void test002(){
        // 按指定模式在字符串查找
        Pattern r = Pattern.compile("(\\D*)(\\d+)(.*)");
        Matcher m = r.matcher("This order was placed for QT3000! OK?");

        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void test003(){
        String MARKET_URL = "https://service-wbs324.newtamp.cn/";
        System.out.println(MARKET_URL.substring(MARKET_URL.length() - 1));
    }

    @Test
    public void test004(){
        String url = "https://marketing-center.newbanker.store/api/v1/inner/baidu/submitapi";
        Map<String,Object> map = new HashMap<>();
        map.put("realm", "ARTICLE");
        //map.put("groupId", WbsCacheProxy.getInstance().getCache().getEntId());
        //map.put("params", String.format("id=%s", existContentInfo.getId()));

        HttpUtils.doPost(url, map);
    }

    @Test
    public void test005(){
        String url = "http://localhost:8080/demo02";
        Map<String,Object> map = new HashMap<>();
        map.put("var0","hahahahahaha");

        System.out.println(HttpUtils.doPost(url,map));
    }
}
