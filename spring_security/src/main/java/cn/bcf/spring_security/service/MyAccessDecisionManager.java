package cn.bcf.spring_security.service;

import cn.bcf.spring_security.bean.Role;
import cn.bcf.spring_security.bean.User;
import cn.bcf.spring_security.mapper.RoleMapper;
import cn.bcf.spring_security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther BiChengfei
 * @Date: 2019/12/5 17:49
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

   @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes){
       if (null == configAttributes || 0 >= configAttributes.size()){
           return;
       } else {
           String needRole;
           for (Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext(); ){
               needRole = iter.next().getAttribute();

               for (GrantedAuthority ga : authentication.getAuthorities()){
                   if (needRole.trim().equals(ga.getAuthority().trim())){
                       return;
                   }
               }
           }
           throw new AccessDeniedException("无访问权限");
       }
   }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


}
