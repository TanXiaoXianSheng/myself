import java.io.Serializable;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/23 18:10
 **/
public class User implements Serializable {

    private int id;
    private String username;
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                '}';
    }
}
