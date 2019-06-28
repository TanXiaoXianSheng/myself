import org.junit.Before;
import org.junit.Test;

public class ThreadPoolTest {

    ThreadPool threadPool = null;

    @Before
    public void before(){
        threadPool = new ThreadPool();
    }

    @Test
    public void singleThreadPool(){
        threadPool.singleThreadPool();
    }

    @Test
    public void cachedThreadPoolTest(){
        threadPool.cachedThreadPool();
    }

    @Test
    public void fixedThreadPoolTest(){
        threadPool.fixedThreadPool();
    }

    @Test
    public void scheduledThreadPool() throws InterruptedException {
        threadPool.scheduledThreadPool();
        Thread.sleep(4000);
    }
}
