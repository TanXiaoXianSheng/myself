package tiger;

//第三题
//先考虑正常情况，再考虑循环
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/2 15:07
 **/
public class _03 {

    public static int getMinLength(String str){
        int min = Integer.MAX_VALUE;
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < str.length();i ++){
            set.add('A');
            set.add('B');
            set.add('C');
            set.add('D');
            set.add('E');
            if (!set.contains(str.charAt(i)))
                continue;
            for (int j = i;j < Integer.MAX_VALUE;j ++){
                //循环情况判断
                if(j == str.length()){
                    j = 0;
                }
                if (set.contains(str.charAt(j))){
                    set.remove(str.charAt(j));
                }
                if (set.isEmpty()){
                    int a = j - i;
                    if (a < 0){
                        a = str.length() - i + j + 1;
                    }
                    if (min > a){
                        min = a;
                    }
                    break;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(_03.getMinLength(str));
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(3);
        Executors.newScheduledThreadPool(3);
        Executors.newSingleThreadExecutor();
    }
}