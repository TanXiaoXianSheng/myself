package reflect;

import com.gitee.easyopen.doc.annotation.ApiDocField;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/16 11:18 上午
 */
public class User implements UserParent{

    @Deprecated
    public Integer id;

    @ApiDocField(name = "username")
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

    private void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {

    }
}
