package niuke;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/25 5:54 下午
 */
public class _08 {

    public int Sum_Solution(int n) {
        int sum=n;
        sum && (sum+=Sum_Solution(n-1));
        return sum;
    }

}
