package proxy.jdk;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/11 15:00
 **/
public class RealSubject implements Subject{


    @Override
    public int sellBooks() {
        System.out.println("卖书");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("说话");
        return "张三";
    }
}
