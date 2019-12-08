package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 这个不用下标存储，然后调换位置，因为直接调换位置可能慢慢的有序了，虽然消耗了空间，但节约了时间
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:25
 **/
public class _05_BubbleSort {

    public static void sort(int[] a){
        boolean flag;
        for (int i = 0;i < a.length - 1; i ++){
            flag = true;
            for (int j = 1;j < a.length - i;j ++){
                if (a[j - 1] > a[j]){
                    SortUtil.swap(a,j - 1,j);
                    flag = false;
                }
            }
            if (flag == true){
                break;
            }
        }
    }

    public static void sort02(int[] a){
        boolean flag = false;
        int index = a.length - 1;
        while (!flag){
            int n = index;
            flag = true;
            for (int i = 0;i < n;i ++){
                if (a[i] > a[i + 1]){
                    SortUtil.swap(a,i,i + 1);
                    index = i;
                    flag = false;
                }
            }
        }
    }

    public static void main(String[] args){
        int a[] = {2,6,1,7,9,8,10,11,6,4,2};

        _05_BubbleSort.sort02(a);
        System.out.println(Arrays.toString(a));

        _05_BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
