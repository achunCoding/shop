package top.wycfight.shop.service;

import top.wycfight.shop.entity.UmsAdmin;
import top.wycfight.shop.entity.UmsPermission;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 后台管理员service
 * @create: 2019-09-24 07:45
 * @modify By:
 **/
public interface UmsAdminService {
    /**
     * 根据用户名获取管理员
     * @param username 用户名
     * @return 管理员实体
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
