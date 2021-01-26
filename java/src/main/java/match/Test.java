package match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String a = "a";
        boolean res = a.matches("\\w");
        System.out.println(res);

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"1");
        map.get(1);
        List<Integer> list = new ArrayList();
        list.equals(list);

        Object obj = new Object();
    }

}
