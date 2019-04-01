package sort;

import java.util.Arrays;

/**
 * 简单选择排序
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:25
 **/
public class _03_SimpleChoiseSort {

    public static void sort(int[] a){
        int minIndex;
        for(int j = 1;j < a.length;j ++){
            minIndex = j - 1;
            for (int i = j;i < a.length;i ++){
                if(a[minIndex] > a[i]){
                    minIndex = i;
                }
            }
            if (minIndex != j - 1){
                SortUtil.swap(a,minIndex,j - 1);
            }
        }
    }

    public static void main(String[] args){
        int a[] = {2,6,1,5,9,8,10,11,6,4,2};
        _03_SimpleChoiseSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
