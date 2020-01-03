package com.xzit.controller.handler;


import com.xzit.controller.annotation.TokenToUser;
import com.xzit.entity.User;
import com.xzit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @ProjectName: ssm-demo
 * @Package: com.ssm.demo.controller.handler
 * @ClassName: TokenToUserMethodArgumentResolver
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/7 17:02
 * @Version: 1.0
 */
public class TokenToUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(TokenToUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        if (methodParameter.getParameterAnnotation(TokenToUser.class) instanceof TokenToUser) {
            User user = null;
            String token = nativeWebRequest.getHeader("token");
            if (null != token && !"".equals(token)) {
                user = userService.getUserByToken(token);
            }
            return user;
        }
        return null;
    }
}
