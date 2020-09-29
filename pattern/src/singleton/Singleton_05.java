package singleton;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton_05 {

    Singleton_05 test = null;
    ReentrantLock lock = new ReentrantLock();

    public Singleton_05 getTest() {
        if (test == null) {
            lock.lock();
                if (test == null) {
                    test = new Singleton_05();
                }
            lock.unlock();
        }
        return test;
    }

    public static void main(String[] args) throws Exception {
        Singleton_05 singleton = new Singleton_05();
        System.out.println("(singleton.getTest() == singleton.getTest()) = " + (singleton.getTest() == singleton.getTest()));
        System.out.println("(new Singleton()).getTest() == (new Singleton()).getTest() = " + ((new Singleton_05()).getTest() == (new Singleton_05()).getTest()));
    }
}
