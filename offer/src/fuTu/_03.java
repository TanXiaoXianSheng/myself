package fuTu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/29 19:08
 **/
public class _03 {

    //先把字符串改成数组，再比对查找
    //把字符串改成数组的时候直接比对
    public static String find(StringBuffer sb){
        String[] a = new String[1000];
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < 1000;i ++){
            if(sb.substring(i,i+1).equalsIgnoreCase("\"")){
                stack.push(i);
                if (stack.size() != 0 && stack.size()%2 == 0){
                    int right = stack.pop();
                    int left = stack.pop();
                    a[j ++] = sb.substring(left,right);
                    sb.replace(left - 1,right,"");
                }
            }
        }
        String[] arr = sb.toString().split(",");
        for (String abc : arr){

        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer str = new StringBuffer();
        if (in.hasNextLine()){
            str.append(in.nextLine());
            System.out.println(find(str));
        }

    }
}
