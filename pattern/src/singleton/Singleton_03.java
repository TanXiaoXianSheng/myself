package singleton;

public class Singleton_03 {

    Singleton_03 test = null;

    public Singleton_03 getTest(){
        synchronized (this) {
            if (test == null){
                test = new Singleton_03();
            }
        }
        return test;
    }

    public static void main(String[] args) throws Exception{
        Singleton_03 singleton = new Singleton_03();
        System.out.println("(singleton.getTest() == singleton.getTest()) = " + (singleton.getTest() == singleton.getTest()));
        System.out.println("(new Singleton()).getTest() == (new Singleton()).getTest() = " + ((new Singleton_03()).getTest() == (new Singleton_03()).getTest()));
    }
}
