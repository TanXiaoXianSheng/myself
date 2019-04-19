package test;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/15 18:46
 **/
public class Main01 {

    int flag = 1;

    public Main01() {
        test();
    }

    void test(){
        System.out.println("super.test()flag=" + flag);
    }

    static class Sub extends Main01{

        //private int flag = 2;

        Sub(int i){
            flag=i;
            System.out.println("Sub.Sub()flag="+flag);
        }
        void test(){
            System.out.println("Sub.test()flag="+flag);
        }
    }
    public static void main(String[] args) {
        //new Main01().new Sub(5);
        Main01 main01 = new Sub(5);

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer,String> map = new HashMap<>();
    }
}
