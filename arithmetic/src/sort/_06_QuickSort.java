package sort;

import java.util.Arrays;

/**
 * 快速排序
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:25
 **/
public class _06_QuickSort {

    public static void sort(int[] a){
        int low = 0;
        int high = a.length - 1;
        sort(a,low,high);
    }

    public static void sort(int[] a,int start,int end){
        int low = start;
        int high = end;
        if (low >= high){
            return;
        }
        int flag = a[low];
        while (low < high){
            while (low < high && a[high] >= flag){
                high --;
            }
            if (low < high){
                a[low ++] = a[high];
            }

            while (low < high && a[low] < flag){
                low ++;
            }
            if (low < high){
                a[high --] = a[low];
            }
        }
        a[low] = flag;
        sort(a,start,low - 1);
        sort(a,low + 1,end);
    }

    public static void main(String[] args){
        int a[] = {2,6,1,5,9,8,10,11,6,4,2};
        //int a[] = {9,1,12,8,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
