package com.xzit.controller;

import com.xzit.commons.Constants;
import com.xzit.commons.Result;
import com.xzit.commons.ResultGenerator;
import com.xzit.controller.annotation.TokenToUser;
import com.xzit.entity.Permission;
import com.xzit.entity.User;
import com.xzit.service.HosService;
import com.xzit.service.PermissionService;
import com.xzit.service.UserService;
import com.xzit.utils.PageResult;
import com.xzit.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.controller
 * @ClassName: UserController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/23 11:50
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @Autowired
    private HosService hosService;

    /**
     * @description:用户登录
     * @author: GaJai
     * @time: 2019/12/24 9:47
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginAccAndPsd){
        Result result= ResultGenerator.genFailResult("登录失败");
        if(StringUtils.isEmpty(loginAccAndPsd.get("loginAccount"))
                || StringUtils.isEmpty(loginAccAndPsd.get("password"))){
            result.setMessage("请填写用户名和密码");
            return result;
        }
        User loginCustom = userService.updateTokenAndLogin(loginAccAndPsd.get("loginAccount"),loginAccAndPsd.get("password"));
        if(loginCustom!=null){
            return ResultGenerator.genSuccessResult(loginCustom);
        }else {
            result.setMessage("用户名或密码错误");
        }
        return result;
    }



    /**
     * @description:首页展示——医院管理、医院查询
     * @author: GaJai
     * @time: 2019/12/24 9:48
     */
//    @RequestMapping(value = "/home",method = RequestMethod.POST)
//    public Result home(@RequestParam Map<String, Object> params,@TokenToUser Customer customer){
//
//        System.out.println("user/home");
//        if(customer==null){//判断是否未登录
//            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN,"未登录");
//        }
//
////        System.out.println(customer.getUserName());
////        System.out.println(customer.getUserType());
//        if(customer.getUserType().equals("1")){//管理员
//            if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
//                return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
//            }
//            //首页医院管理——获取所有医院
//            Map map=new HashMap();
////            map.put("page",1);
////            map.put("limit",10);
//            return ResultGenerator.genSuccessResult(hosService.getAllHos(new PageUtil(params)));
//
//        }else if (customer.getUserType().equals("2")){//医院管理员
//            //医生管理
//
//        } else if(customer.getUserType().equals("3")){//医生
//            //预约列表
//
//        }else if(customer.getUserType().equals("4")){//用户
//            //医院查询、医生查询
//
//        }
//        return null;
//    }


}
