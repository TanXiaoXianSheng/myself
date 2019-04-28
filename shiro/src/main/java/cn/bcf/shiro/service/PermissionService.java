package cn.bcf.shiro.service;

import org.apache.shiro.authz.Permission;

/**
 *
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 18:33
 **/
public interface PermissionService {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
