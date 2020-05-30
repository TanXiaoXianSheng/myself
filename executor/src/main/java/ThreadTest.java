public class ThreadTest {

    public static void main(String[] args) {
        Thread thread01 = new Thread01();
        thread01.start();
        Runnable runable = new Thread02();
        Thread thread02 = new Thread(runable);
        thread02.start();
    }


}

class Thread01 extends Thread{

    @Override
    public void run() {
        System.out.println("继承Thread");
    }
}

class Thread02 implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable");
    }
}
