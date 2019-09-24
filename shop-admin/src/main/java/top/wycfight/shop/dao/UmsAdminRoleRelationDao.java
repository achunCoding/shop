package top.wycfight.shop.dao;

import org.apache.ibatis.annotations.Param;
import top.wycfight.shop.entity.UmsPermission;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-09-24 07:59
 * @modify By:
 **/
public interface UmsAdminRoleRelationDao {


    /**
     * 获取用户所有权限 （包括角色和+-权限）
     * @param adminId 管理员ID
     * @return 用户权限
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
