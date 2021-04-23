package niuke;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/22 1:51 下午
 */
public class _02 {

    public int minNumberInRotateArray(int [] array) {
        return minNumberInRotateArray(0, array.length - 1, array);
    }

    public int minNumberInRotateArray(int start, int end, int[] array) {
        if(start == end)
            return array[start];
        int left = array[start];
        int right = array[end];
        int midIndex = (start + end) / 2;
        int mid = array[midIndex];
        if (mid > right) {
            return minNumberInRotateArray(midIndex + 1, end, array);
        } else if (mid < right) {
            return minNumberInRotateArray(start, midIndex, array);
        } else {
            return minNumberInRotateArray(start, end - 1, array);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        _02 obj = new _02();
        System.out.println(obj.minNumberInRotateArray(arr));
    }

}
