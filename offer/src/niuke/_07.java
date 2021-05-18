package niuke;

import java.util.Scanner;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/25 11:41 上午
 */
public class _07 {

    public static int fun(String str) {
        int[] arr = new int[256];
        for (int i = 0;i < str.length();i ++) {
            arr[str.charAt(i)] = arr[str.charAt(i)] + 1;
        }
        for (int i = 0;i < str.length();i ++) {
            if (arr[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";
        //str = in.nextLine();
        str = "google";
        System.out.println(fun(str));

    }

}
