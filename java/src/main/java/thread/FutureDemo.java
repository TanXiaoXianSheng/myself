package thread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/8 4:54 下午
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
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

}
