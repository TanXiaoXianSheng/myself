package search;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/1 10:43
 **/
public class BinarySearch {

    //返回下标
    public static int search(int[] a,int value){
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int recursion = searchRecursion(a,0,a.length - 1,value);
        int noRecursion = searchNoRecursion(a,0,a.length - 1,value);
        System.out.println("递归：" + recursion + "非递归:" + noRecursion);
        return recursion;
    }

    //返回所有下标
    public static List<Integer> searchAll(int[] a,int value){
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();
        int index = searchRecursion(a,0,a.length - 1,value);
        list.add(index);
        //向左 <--
        for (int i = index - 1;i >= 0;i --){
            if (a[i] == a[index])
                list.add(i);
            else
                break;
        }
        //向右 -->
        for (int i = index + 1;i < a.length;i ++){
            if (a[i] == a[index])
                list.add(i);
            else
                break;
        }
        return list;
    }

    //递归
    public static int searchRecursion(int[] a,int low,int high,int value){
        if (low < high){
            int middle = (high + low)/2;
            if (a[middle] == value){
                return middle;
            }
            if (a[middle] < value){
                return searchRecursion(a,middle + 1,high,value);
            }
            if (a[middle] > value){
                return searchRecursion(a,low,middle - 1,value);
            }
        }
        return -1;
    }

    //非递归
    public static int searchNoRecursion(int[] a,int low,int high,int value){
        while (low <= high){
            int mid = (high + low)/2;
            if(a[mid] == value)
                return mid;
            if(a[mid] > value)
                high = mid - 1;
            if (a[mid] < value)
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int a[] = {2,6,1,3,9,8,10,11,6,4,2};
        System.out.println(search(a,2));

        List<Integer> list = searchAll(a,2);
        Collections.sort(list);
        System.out.println(list);
    }
}
