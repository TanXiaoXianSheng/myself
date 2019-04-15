package proxy;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/11 14:54
 **/
public class ProxyPatternDemo {

    public static void main(String[] args){
        Image image = new ProxyImage("test_10mb.jpg");

        image.display();
        System.out.println("");
        image.display();

    }
}
