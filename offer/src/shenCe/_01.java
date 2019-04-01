package shenCe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/29 15:45
 **/
public class _01 {

    public static void find(int[] a,int[] b){
        int num = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0;i < a.length;i ++){
            for (int j = 0;j < b.length;j ++){
                if (a[i] < a[j]){
                    num ++;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int aLength;
        int bLength;

        aLength = in.nextInt();
        int[] a = new int[aLength];
        for(int i = 0;i < aLength;i ++){
            a[i] = in.nextInt();
        }

        bLength = in.nextInt();
        int[] b = new int[bLength];
        for (int i = 0;i < bLength;i ++){
            b[i] = in.nextInt();
        }
        find(a,b);
        System.out.println(Arrays.toString(a) + "\n----\n" + Arrays.toString(b));
    }
}
