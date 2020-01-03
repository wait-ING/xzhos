package com.xzit.controller;

import com.xzit.commons.Constants;
import com.xzit.commons.Result;
import com.xzit.commons.ResultGenerator;
import com.xzit.controller.annotation.TokenToUser;
import com.xzit.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.controller
 * @ClassName: SupAdminController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/1/2 12:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("/supAdmin")
public class SupAdminController {


    /**
     * @description:获取角色列表
     * @author: GaJai
     * @time: 2020/1/3 10:59
     */
    @RequestMapping(value = "/listRoles",method = RequestMethod.POST)
    public Result getRoles(@TokenToUser User user){
        if (user==null){
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN,"未登录");
        }
//        获取角色列表

        return null;
    }

}
