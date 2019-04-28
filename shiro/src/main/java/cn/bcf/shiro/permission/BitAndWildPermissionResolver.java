package cn.bcf.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 17:49
 **/
public class BitAndWildPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String s) {
        if (s.startsWith("+")){
            return new BitPermission(s);
        }
        return new WildcardPermission(s);
    }
}
