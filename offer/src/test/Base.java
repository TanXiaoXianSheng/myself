package test;

public class Base
{
     String baseName = "base";
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        //private String baseName = "sub";

        public Sub(String baseName) {
            this.baseName = baseName;
        }

        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub("sub");
    }
}