package com.xzit.dao;

import com.xzit.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.dao
 * @ClassName: UserDao
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/30 16:05
 * @Version: 1.0
 */
public interface UserDao {

    /**
     * @description:账号、密码查找用户
     * @author: GaJai
     * @time: 2019/12/30 16:05
     */
    User getUserByAccount(@Param("account") String account, @Param("password") String password);

    /**
     * @description:更新用户Token
     * @author: GaJai
     * @time: 2019/12/30 17:03
     */
    Integer updateToken(@Param("userId") String userId,@Param("token") String token);

    /**
     * @description:根据Token获取用户
     * @author: GaJai
     * @time: 2019/12/30 18:24
     */
    User getUserByToken(String token);
}
