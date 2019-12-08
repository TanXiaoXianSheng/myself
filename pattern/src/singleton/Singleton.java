package singleton;

public class Singleton {

    Singleton test = null;

    public Singleton getTest() throws Exception{
        if (test == null){
            test = new Singleton();
        }
        Thread.sleep(10000);
        return test;
    }

    public static void main(String[] args) throws Exception{
        Singleton singleton = new Singleton();
        System.out.println("(singleton.getTest() == singleton.getTest()) = " + (singleton.getTest() == singleton.getTest()));
        System.out.println("(new Singleton()).getTest() == (new Singleton()).getTest() = " + ((new Singleton()).getTest() == (new Singleton()).getTest()));
    }
}
