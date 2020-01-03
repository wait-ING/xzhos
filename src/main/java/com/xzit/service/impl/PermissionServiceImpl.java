package com.xzit.service.impl;

import com.xzit.dao.PermissionDao;
import com.xzit.entity.Permission;
import com.xzit.entity.model.PermissionMenu;
import com.xzit.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service.impl
 * @ClassName: PermissionServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/30 23:53
 * @Version: 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * @description:登录用户权限菜单
     * @author: GaJai
     * @time: 2019/12/28 22:01
     */
    @Override
    public List<PermissionMenu> getPermissionMenu(String userId, String parentId) {
        /*超级管理员--->权限管理
        * 管理员--->医院管理、医生管理、订单管理、患者管理
        * 医院管理者--->医院管理、医生管理、订单查看、患者查看、值班管理
        * 医生--->预约单查看
        * 患者--->预约医生
        * 从数据库读取数据动态生成树形菜
        * */
        List<PermissionMenu> permissionMenus=new ArrayList<PermissionMenu>();
        getPermissionMenuSubList(userId,parentId,permissionMenus);
        return permissionMenus;
    }
    /**
     * @description:获取parentId权限下的---子权限
     * @author: GaJai
     * @time: 2020/1/2 0:26
     */
    private void getPermissionMenuSubList(String userId,String parentId,List<PermissionMenu> permissionMenus){

        for(PermissionMenu permissionMenu:getPermissionMenuByLevel(userId, parentId)){
            permissionMenuSubItemList(userId,permissionMenu,permissionMenus);
        }
    }
    /**
     * @description:获取某个权限的子权限
     * @author: GaJai
     * @time: 2020/1/2 0:28
     */
    private void permissionMenuSubItemList(String userId,PermissionMenu permissionMenu,List<PermissionMenu> permissionMenus){

        if(isUri(permissionMenu)){//是
            permissionMenus.add(permissionMenu);
            return ;
        }else {
            permissionMenus.add(permissionMenu);
            getPermissionMenuSubList(userId,permissionMenu.getId(),permissionMenu.getSubPermission());
        }
    }
    /**
     * @description:获取某个用户父权限下的子权限
     * @author: GaJai
     * @time: 2020/1/2 0:28
     */
    private List<PermissionMenu> getPermissionMenuByLevel(String userId, String parentId){
        return  permissionDao.getPermissionMenuByLevel(userId, parentId);
    }
    /**
     * @description:是否是叶子权限——uri
     * @author: GaJai
     * @time: 2020/1/2 0:28
     */
    private Boolean isUri(Permission permission){
        if(permission.getUri().trim().equals("")||permission.getUri()==null){
            return false;
        }else {
            return true;
        }
    }



}
