package reflect;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/20 8:24 下午
 */
public interface UserParent {

    default void defaultMethod(){
        System.out.println("1111");
    }

    public void run();
}
