package common;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/16 11:18 上午
 */
public class User {

    public Integer id;
    private String username;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
