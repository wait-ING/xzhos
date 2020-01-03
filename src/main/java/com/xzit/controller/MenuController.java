package com.xzit.controller;

import com.xzit.commons.Constants;
import com.xzit.commons.Result;
import com.xzit.commons.ResultGenerator;
import com.xzit.controller.annotation.TokenToUser;
import com.xzit.entity.User;
import com.xzit.entity.model.PermissionMenu;
import com.xzit.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.controller
 * @ClassName: MenuController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/31 12:17
 * @Version: 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private PermissionService permissionService;
    /**
     * @description:登录用户的权限菜单
     * @author: GaJai
     * @time: 2019/12/28 21:15
     */

    /**
     * @description:获取权限菜单
     * @author: GaJai
     * @time: 2020/1/2 4:32
     */
    @RequestMapping(value = "/menuInit",method = RequestMethod.POST)
    public Result getPermissionMenuInit(@TokenToUser User user){
        if(user==null){
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN,"未登录!");
        }
        List<PermissionMenu> permissionMenu = permissionService.getPermissionMenu(user.getId(), "-1");
        System.out.println(permissionMenu);
        return ResultGenerator.genSuccessResult(permissionMenu);
    }





//    @RequestMapping("/menuInit")
//    public Result getMenuInit(@TokenToUser User user){
//        System.out.println("user===>"+user);
//        //1、判断用户是否登录
//        if(user==null){
//            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN,"未登录!");
//        }
//        //封装初始菜单
////        List<Permission> permissionMenuInit = permissionService.getPermissionMenu(user.getId(), "-1");
////        return ResultGenerator.genSuccessResult(permissionMenuInit);
//        return null;
//    }
//
//
//    /**
//     * @description:获取子菜单
//     * @author: GaJai
//     * @time: 2019/12/31 12:54
//     */
//    @RequestMapping(value = "/getMenu",method = RequestMethod.POST)
//    public Result getMenu(@TokenToUser User user, @RequestBody Map<String,String> map){
//        //1、判断用户是否登录
//        if(user==null){
//            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN,"未登录!");
//        }
//        //菜单
////        List<Permission> permissionMenu = permissionService.getPermissionMenuByLevel(user.getId(), map.get("parentId"));
////        return ResultGenerator.genSuccessResult(permissionMenu);
//        return null;
//    }
}
