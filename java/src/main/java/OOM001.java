import java.util.ArrayList;
import java.util.List;

public class OOM001 {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0;i < Integer.MAX_VALUE;i ++) {
            byte[] bytes = new byte[1024];
            list.add(bytes);

            Thread.sleep(10);
            System.out.println(i);
        }
    }
}
