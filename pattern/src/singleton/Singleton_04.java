package singleton;

public class Singleton_04 {

    Singleton_04 test = null;

    public Singleton_04 getTest() {
        if (test == null) {
            synchronized (this) {
                if (test == null) {
                    test = new Singleton_04();
                }
            }
        }
        return test;
    }

    public static void main(String[] args) throws Exception {
        Singleton_04 singleton = new Singleton_04();
        System.out.println("(singleton.getTest() == singleton.getTest()) = " + (singleton.getTest() == singleton.getTest()));
        System.out.println("(new Singleton()).getTest() == (new Singleton()).getTest() = " + ((new Singleton_04()).getTest() == (new Singleton_04()).getTest()));
    }
}
