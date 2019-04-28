package cn.bcf.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 17:51
 **/
public class MyRolePermissionResolver implements RolePermissionResolver {

    @Override
    public Collection<Permission> resolvePermissionsInRole(String s) {
        if ("role01".equalsIgnoreCase(s)){
            return Arrays.asList((Permission) new WildcardPermission("menu:*"));
        }
        return null;
    }
}
