package thread;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * https://www.cnblogs.com/cjsblog/p/9267163.html
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/8 5:07 下午
 */
public class FutureTest {

    @Test
    public void test001() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        System.out.println(LocalDateTime.now());
        Future<Integer> future = pool.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println(LocalDateTime.now());
        System.out.println(future.get());
        System.out.println("finish");
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void test002() {

    }

}
