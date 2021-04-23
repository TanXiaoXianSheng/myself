package collection;

import common.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    public void test001() {
        List<String> list = new ArrayList<String>(){
            {
                add("1");
            }
        };
    }

    @Test
    public void test002() {
        List<String> list = new ArrayList<>();
        list.add("1");
    }

    @Test
    public void test003() {
        new ArrayList<String>(){
            {
                add("1");
            }
        };
    }

    @Test
    public void test004() {
        /*ArrayList<String> list = new ArrayList<String>() {
            "1"
        };*/

    }

    @Test
    public void test005() {
        Map<String, String> map = new HashMap<>();
        map.get("1111");
    }

    @Test
    public void test006() {
        List<User> list = new ArrayList<User>(){
            {
                add(new User(1, "AA"));
                add(new User(2, "BB"));
            }
        };

        //String str = StringUtils.join(list.stream().collect(Collectors.toCollection());
        String str01 = StringUtils.join(list.stream().map(x -> x.getUsername()).collect(Collectors.toList()), ",");
        System.out.println(str01);
        String str02 = StringUtils.join(list.stream().map(x -> x.getUsername()).collect(Collectors.toList()));
        System.out.println(str02);
        String str03 = StringUtils.join(list.stream().map(User::getUsername).collect(Collectors.toList()), "/");
        System.out.println(str03);
    }

    @Test
    public void test007() {
        List<User> list = new ArrayList<User>(){

        };

        //String str = StringUtils.join(list.stream().collect(Collectors.toCollection());
        String str01 = StringUtils.join(list.stream().map(x -> x.getUsername()).collect(Collectors.toList()), ",");
        System.out.println(str01);
        String str02 = StringUtils.join(list.stream().map(x -> x.getUsername()).collect(Collectors.toList()));
        System.out.println(str02);
        String str03 = StringUtils.join(list.stream().map(User::getUsername).collect(Collectors.toList()), "/");
        System.out.println(str03);
    }

}
