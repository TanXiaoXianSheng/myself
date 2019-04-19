package test;

public class Base01
{
    private int flag = 1;
    public Base01()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(flag);
    }

    static class Sub extends Base01
    {
        private int flag = 2;

        public Sub(int flag) {
            this.flag = flag;
        }

        public void callName()
        {
            System. out. println (flag) ;
        }
    }
    public static void main(String[] args)
    {
        Base01 b = new Sub(3);
    }
}