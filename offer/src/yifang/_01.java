package yifang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/4 20:04
 **/
public class _01 {

    public static int find(String str){
        int zhouchang = 0;
        String[] arr = str.split(",");
        int[] a = new int[arr.length];
        for (int i = 0;i < arr.length;i ++){
            a[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(a);
        for (int i = a.length - 1;i >= 2;i --){
            if (a[i - 2] + a[i - 1] > a[i]){
                zhouchang = a[i - 2] + a[i - 1] + a[i];
                break;
            }
        }
        return zhouchang;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int a = find(str);
        System.out.println(a);
    }
}
