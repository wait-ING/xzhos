package com.xzit.service;

import com.xzit.entity.Permission;
import com.xzit.entity.User;

import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service
 * @ClassName: UserService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/23 14:10
 * @Version: 1.0
 */
public interface UserService {

    /**
     * @description:登录
     * @author: GaJai
     * @time: 2019/12/23 14:26
     */
    User updateTokenAndLogin(String loginAccount,String password);

    /**
     * @description:登录的用户
     * @author: GaJai
     * @time: 2019/12/24 9:52
     */
    User getUserByToken(String token);


}
