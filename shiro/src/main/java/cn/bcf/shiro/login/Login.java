package cn.bcf.shiro.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.stereotype.Component;


/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 16:53
 **/
@Component
public class Login extends Base{

    public void login(String filePath,String username,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(filePath);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            System.out.println("登录成功");
        }catch (AuthenticationException e){
            e.printStackTrace();
        }
    }

    public void logout(){
        getSubject().logout();
    }

}
