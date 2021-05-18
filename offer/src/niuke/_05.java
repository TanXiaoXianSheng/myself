package niuke;

import java.util.Scanner;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/23 4:24 下午
 */
public class _05 {

    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int value = arr[0];
        int count = 1;
        for (int i = 0;i < arr.length;i ++) {
            if (i == 0) {
                value = arr[i];
            } else {
                if (value == arr[i]) {
                    count ++;
                } else {
                    count --;
                    if (count == 0) {
                        count = 1;
                        value = arr[i];
                    }
                }
            }
            //System.out.println("i = " + i + ",count = " + count + ",value = " + value);
        }

        int num = 0;
        for (int i = 0;i < arr.length;i ++) {
            if (arr[i] == value) {
                num ++;
            }
        }

        if (num > arr.length / 2) {
            return value;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        int[] arr = new int[length];
        for (int i = 0;i < arr.length;i ++) {
            arr[i] = in.nextInt();
        }
        System.out.println(fun(arr));

    }

}
