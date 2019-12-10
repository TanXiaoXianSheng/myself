package cn.bcf.spring_security.service;

import cn.bcf.spring_security.bean.RolePermisson;
import cn.bcf.spring_security.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 请求--权限对应关系
 * @Auther BiChengfei
 * @Date: 2019/12/6 10:27
 */
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionMapper permissionMapper;

    private static HashMap<String,Collection<ConfigAttribute>> map = null;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null){
            loadResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ){
            String url = it.next();
            if (new AntPathRequestMatcher(url).matches(request)){
                return map.get(url);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public void loadResourceDefine(){
        map = new HashMap<>();
        List<RolePermisson> rolePermissionList = permissionMapper.getRolePermissions();

        for (RolePermisson rolePermisson: rolePermissionList){
            String url = rolePermisson.getUrl();
            String roleName = rolePermisson.getRoleName();
            ConfigAttribute role = new SecurityConfig(roleName);

            if (map.containsKey(url)){
                map.get(url).add(role);
            } else {
                List<ConfigAttribute> list = new ArrayList<>();
                list.add(role);
                map.put(url,list);
            }
        }
    }
}
