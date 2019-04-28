package cn.bcf.shiro.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 17:01
 **/
@Component
public class Base {

    public static Subject getSubject(){
        Subject subject =  SecurityUtils.getSubject();
        if (subject != null){
            return subject;
        }else
            throw new NullPointerException("subject 为空");
    }
}
