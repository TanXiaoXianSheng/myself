package fuTu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/29 18:46
 **/
public class _02 {

    public static String fanZhuan(StringBuffer inputString){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < inputString.length();i ++){
            stack.push(inputString.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < inputString.length();i ++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer str = new StringBuffer();
        str.append(in.nextLine());

        System.out.println(fanZhuan(str));
    }
}
