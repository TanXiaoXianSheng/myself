package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:25
 **/
public class _02_ShellSort {

    public static void sort(int[] a){
        for (int gap = a.length/2;gap >= 1;gap = gap / 2){
            for (int i = 0;i < gap;i ++){
                //[i,i + grap,i + 2*grap,...]  当i + n * grap > a.length终止
                for (int j = i;j < a.length;j = j + gap){
                    for (int m = j - gap;m >= 0;m = m - gap){
                        if (a[m + gap] < a[m]){
                            SortUtil.swap(a,m,m + gap);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int a[] = {2,6,1,3,9,8,10,11,6,4,2};
        _02_ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
