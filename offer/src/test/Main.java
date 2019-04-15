package test;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/15 18:46
 **/
public class Main {

    class Super{

        int flag=1;
        Super(){
            test();
        }
        void test(){
            System.out.println("Super.test() flag="+flag);
        }
    }
    class Sub extends Super{

        Sub(int i){
            flag=i;
            System.out.println("Sub.Sub()flag="+flag);
        }
        void test(){
            System.out.println("Sub.test()flag="+flag);
        }
    }
    public static void main(String[] args) {
        new Main().new Sub(5);
    }
}
