package com.xzit.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @ProjectName: ssm-demo
 * @Package: com.ssm.demo.utiles
 * @ClassName: TokenUtil
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/7 13:49
 * @Version: 1.0
 */
public class TokenUtil {


    /**
     * @description:
     * @param
     * @return:
     * @author: GaJai
     * @time: 2019/12/7 12:14
     */
    public static String getNewToken(String sessionId, String userId) {
        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return genToken(src);
    }

    /**
     * 登录或注册成功后,生成保持用户登录状态会话token值
     * @param src:为用户最新一次登录时的now()+user.id+random(4)
     * @return
     */
    private static String genToken(String src){
        if (null == src || "".equals(src)){
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return null;
        }
    }
}
