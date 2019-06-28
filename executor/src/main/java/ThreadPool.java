import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ThreadPool {

    /**
     * 可缓存线程池
     */
    public void cachedThreadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0;i < 10;i ++){
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    /**
     * 定长线程池
     */
    public void fixedThreadPool(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0;i < 10;i ++){
            final int index = i;

            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 具有定时功能的定长线程池
     */
    public void scheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟三秒后执行,这里是demo,还没等到3s，JVM就关闭了，所以没有结果
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                    System.out.println("delay 3 seconds");
            }
        },3, TimeUnit.SECONDS);

        //延迟1s后，没3s执行一次
        /*scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1s,and execute every 3s");
            }
        },1,2,TimeUnit.SECONDS);*/
    }

    /**
     * 单线程化线程池
     */
    public void singleThreadPool(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0;i < 10;i ++){
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
