/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/8 14:34
 **/
public class _07 {

    int[] a = new int[40];

    public int Fibonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(a[n] == 0)
            a[n] = Fibonacci(n - 1) + Fibonacci(n - 2);
        return a[n];
    }
}
