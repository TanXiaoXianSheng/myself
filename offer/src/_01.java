/**
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/25 16:07
 **/
public class _01 {

    public boolean Find(int target, int [][] array) {
        boolean flag = false;
        for (int i = 0;i < array.length;i ++){
            for(int j = 0;j < array[0].length;j ++){
                if (target == array[i][j]){
                    flag = true;
                }
            }
        }
        return flag;
    }
}
