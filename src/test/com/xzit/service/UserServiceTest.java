package com.xzit.service;

import com.xzit.entity.User;
import com.xzit.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service
 * @ClassName: UserServiceTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/30 16:27
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void updateTokenAndLogin() throws Exception {

//        String s = MD5Util.MD5Encode("123456", "UTF-8");
//        System.out.println(s);

        User user = userService.updateTokenAndLogin("1234567890", "123456");
        System.out.println(user.toString());
    }

    @Test
    public void getUserByToken() throws Exception {
        User userByToken = userService.getUserByToken("5617ef0d3f8e4fd95954ff6bdd4d6487");
        System.out.println(userByToken.toString());

    }
}