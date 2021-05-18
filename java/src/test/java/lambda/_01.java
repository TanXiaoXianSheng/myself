package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Function;

import static java.lang.System.*;

/**
 * https://blog.csdn.net/hopelgl/article/details/103593823
 *
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/8 6:24 下午
 */
public class _01 {

    @Test
    public void test001() {
        Comparator<Integer> com01 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        com01.compare(1,2);
    }

    @Test
    public void test002() {
        Function<Integer, Integer> function01 = x -> x + 2;
        Function<Integer, Integer> function02 = x -> x + 3;
        out.println(function01.apply(1));
        out.println(function01.andThen(function02).apply(1));
    }

}
