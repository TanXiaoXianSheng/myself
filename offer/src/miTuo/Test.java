package miTuo;

import java.util.Arrays;

public class Test {

    public static void first(int[] a){
        int p = a.length - 1,q= a.length - 1;
        for (int i = a.length - 1;i >= 0 && p >= 0;i --){
            if (a[p] == a[q] && a[p] == 0){
                p --;
                q --;
                continue;
            }
            if (a[p] == 0 && a[q] != 0){
                swap(a,p,q);
                p --;
                q --;
                continue;
            }
            p --;
        }
    }

    public static int second(int k){
        if (k == 0)
            return 0;
        int[] a = new int[100];
        int i = 0;
        while (k > 0){
            a[i ++] = k % 10;
            k = k/10;
        }
        for (int j = 0;j < i - 1;j ++){
            if (a[j] > a[j + 1]){
                swap(a,j,j + 1);
                break;
            }
        }
        StringBuffer result = new StringBuffer();
        for (int j = i - 1;j >= 0;j --){
            result.append(a[j]);
        }
        return Integer.parseInt(result.toString());
    }

    public static void swap(int[] a,int i,int j){
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    public static void main(String[] args){
        int[] a = {1,0,2,0,-1,5,0};
        first(a);
        System.out.println("第一题：" + Arrays.toString(a));

        int k = 0;
        int result = second(k);
        System.out.print("第二题：");
        if (result == k){
            System.out.println("不存在");
        }else {
            System.out.println(result);
        }
    }

}
