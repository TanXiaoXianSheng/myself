package provider.bean;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/16 2:21 下午
 */
public class StudentBean {

    public Integer id;
    public String name;

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
