package com.xzit.service.impl;

import com.xzit.dao.UserDao;
import com.xzit.entity.*;
import com.xzit.service.UserService;
import com.xzit.utils.MD5Util;
import com.xzit.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service.impl
 * @ClassName: UserServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/23 14:26
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService  {


    @Autowired
    private UserDao userDao;


    /**
     * @description:用户登录
     * @author: GaJai
     * @time: 2019/12/23 14:26
     */
    @Override
    public User updateTokenAndLogin(String loginAccount,String password) {
        User user = userDao.getUserByAccount(loginAccount, MD5Util.MD5Encode(password,"UTF-8"));
        if(user!=null){//登录后添加Token
            String newToken= TokenUtil.getNewToken(System.currentTimeMillis()+"",user.getId());
            if(userDao.updateToken(user.getId(), newToken)==1){
                user.setToken(newToken);
                return user;
            }
        }
        return null;
    }

    /**
     * @description:登录用户Token验证
     * @author: GaJai
     * @time: 2019/12/24 9:54
     */
    @Override
    public User getUserByToken(String token) {
        User userByToken = userDao.getUserByToken(token);

        return userByToken;
    }



}
