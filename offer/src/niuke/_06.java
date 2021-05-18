package niuke;

import java.util.Scanner;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/23 6:24 下午
 */
public class _06 {

    public static int fun(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return arr[1];
        int max = arr[0];
        int sum = arr[0];
        //int left = 0;
        //int right = 0;
        for(int i = 1;i < arr.length;i ++) {
            int temp = sum + arr[i];
            if(temp > sum) {
                if (temp > arr[i]) {
                    sum = temp;
                } else {
                    sum = arr[i];
                    //left = i;
                }
            } else {
                max = max > sum ? max : sum;
                if(temp > arr[i]) {
                    sum = temp;
                } else {
                    sum = arr[i];
                    //left = i;
                }
            }
            //right = i;
        }

        return max > sum ? max : sum;
    }

    public static int fun02(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return arr[1];
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1;i < arr.length;i ++) {
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = max > sum ? max : sum;
        }
        return max;
    }

    public static int fun03(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return arr[1];
        int max = arr[0];
        int sum = arr[0];
        int left = 0;
        int right = 0;
        for (int i = 1;i < arr.length;i ++) {
            if (sum > 0) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
                left = i;
            }
            max = max > sum ? max : sum;
            right = i;
        }
        return max;
    }

    public static void main(String[] args) {
        Math.max(1,2);
        int[] arr01 = {1,-2,3,10,-4,7,2,-5};
        System.out.println(fun(arr01));
        System.out.println(fun02(arr01));
        System.out.println(fun03(arr01));
        int[] arr02 = {-2,-8,-1,-5,-9};
        System.out.println(fun(arr02));
        System.out.println(fun02(arr02));
        System.out.println(fun03(arr02));
        int[] arr03 = {2,8,1,5,9};
        System.out.println(fun(arr03));
        System.out.println(fun02(arr03));
        System.out.println(fun03(arr03));
    }

}
