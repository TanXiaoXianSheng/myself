package generies;

public class ClassName<T> {

    void show01(T t) {
        System.out.println("show01:" + t.toString());
    }

    <E> void show02(E e) {
        System.out.println("show02:" + e.toString());
    }

    <T> void show03(T t) {
        System.out.println("show03:" + t.toString());
    }

    public static void main(String[] args) {
        ClassName<Fruit> obj = new ClassName<>();
        Fruit f = new Fruit();
        Apple a = new Apple();
        Person p = new Person();

        obj.show01(f);
        obj.show02(f);
        obj.show03(f);

        obj.show01(a);
        obj.show02(a);
        obj.show03(a);

        //obj.show01(p);
        obj.show02(p);
        obj.show03(p);
    }
}
