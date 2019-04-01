package sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:24
 **/
public class _01_SimpleInsertSort {

    public static void sort(int[] a){
        for (int i = 1;i < a.length;i ++){
            for (int j = i - 1;j >= 0;j --){
                if (a[j + 1] < a[j]){
                    SortUtil.swap(a,j + 1,j);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int a[] = {2,6,1,3,9,8,10,11,6,4,2};
        _01_SimpleInsertSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
