package sort;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/28 15:21
 **/
public class SortUtil {

    /**
     * 用来交换数字数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr,int a,int b){
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
