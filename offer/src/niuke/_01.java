package niuke;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/22 10:36 上午
 */
public class _01 {

    public static boolean Find(int target, int [][] array) {
        for(int i = 0;i < array.length;i ++) {
            for(int j = 0;j < array[i].length;j ++) {
                if(array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 1500;
        int[][] arr = {
                {1,3,5},
                {2,4,6},
                {11,12,1500}
        };
        System.out.println(Find(1500, arr));
    }

}
