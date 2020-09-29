package singleton;

public class Singleton_02 {

    Singleton_02 test = null;

    public synchronized Singleton_02 getTest(){
        if (test == null){
            test = new Singleton_02();
        }
        return test;
    }

    public static void main(String[] args) throws Exception{
        Singleton_02 singleton = new Singleton_02();
        System.out.println("(singleton.getTest() == singleton.getTest()) = " + (singleton.getTest() == singleton.getTest()));
        System.out.println("(new Singleton()).getTest() == (new Singleton()).getTest() = " + ((new Singleton_02()).getTest() == (new Singleton_02()).getTest()));
    }
}
