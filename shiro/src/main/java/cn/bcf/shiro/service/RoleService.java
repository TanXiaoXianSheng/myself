package cn.bcf.shiro.service;

import cn.bcf.shiro.entity.Role;

/**
 *
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 18:34
 **/
public interface RoleService {

    public Role createRole(Role role);

    public void deleteRole(Long roleId);

    //添加角色-权限之间关系
    public void correlationPermissions(Long roleId, Long... permissionIds);

    //移除角色-权限之间关系
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
