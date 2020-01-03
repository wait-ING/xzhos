package com.xzit.service;


import com.xzit.entity.model.PermissionMenu;

import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service
 * @ClassName: PermissionService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/30 23:52
 * @Version: 1.0
 */
public interface PermissionService {
    /**
     * @description:获取用户的权限
     * @author: GaJai
     * @time: 2019/12/30 19:01
     */
    List<PermissionMenu> getPermissionMenu(String userId, String parentId);



}
