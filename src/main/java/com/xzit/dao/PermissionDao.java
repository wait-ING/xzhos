package com.xzit.dao;

import com.xzit.entity.model.PermissionMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.dao
 * @ClassName: PermissionDao
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/30 18:59
 * @Version: 1.0
 */
public interface PermissionDao {

    /**
     * @description:获取用户-角色-权限-菜单
     * @author: GaJai
     * @time: 2019/12/30 23:55
     */
    List<PermissionMenu> getPermissionMenuByLevel(@Param("usrId") String userId, @Param("parentId") String parentId);



}
