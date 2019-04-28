package cn.bcf.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 17:06
 **/
@Component
public class MyRealm01 implements Realm {

    @Override
    public String getName() {
        return "MyRealm01";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
