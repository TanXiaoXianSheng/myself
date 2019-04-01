package shenCe;

import java.util.*;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/29 15:45
 **/
public class _02 {

    public static void find(int[] a,int length,int sum){
        int flagSum =0;
        int temp = length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        //先判断是否有
        while (length > 0 && a[-- temp] > 0){
            flagSum += a[temp];
        }
        if (flagSum < sum){
            return;
        }
        //双层循环再二分查找剩下的一个

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int aLength;
        int sum;

        aLength = in.nextInt();
        sum = in.nextInt();
        int[] a = new int[aLength];
        for(int i = 0;i < aLength;i ++){
            a[i] = in.nextInt();
        }

        find(a,aLength,sum);
        System.out.println(Arrays.toString(a) + "\n----\n" + sum);
    }
}
