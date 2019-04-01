package sort;

import java.util.Arrays;

/**
 * 归并排序
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:25
 **/
public class _07_MergeSort {

    public static void sort(int[] a){
        int[] temp = new int[a.length];
        sort(a,0,a.length - 1,temp);
    }

    public static void sort(int[] a,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            sort(a,left,mid,temp);
            sort(a,mid + 1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }

    public static void merge(int[] a,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (a[i] <= a[j]){
                temp[t ++] = a[i ++];
            }else {
                temp[t ++] = a[j ++];
            }
        }
        while (i > mid && j <= right){
            temp[t ++] = a[j ++];
        }
        while (i <= mid && j > right){
            temp[t ++] = a[i ++];
        }
        t = 0;
        while (left <= right){
            a[left ++] = temp[t ++];
        }
    }

    public static void main(String[] args){
        int a[] = {2,6,1,3,9,8,10,11,6,4,2};
        //int a[] = {9,1,12,8,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
