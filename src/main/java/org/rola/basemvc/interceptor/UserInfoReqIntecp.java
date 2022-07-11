package org.rola.basemvc.interceptor;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author D
 * @date 2022/7/8
 * @Class UserInfoReqIntecp
 * @description  继承 UserRoleAuthorizationInterceptor 其中的 preHandler() 验证 用户的请求中的角色信息  request.isUserInRole
 */
@ControllerAdvice
public class UserInfoReqIntecp extends UserRoleAuthorizationInterceptor {
    /**
     * 此拦截器处理未授权的请求。默认实现发送 HTTP 状态代码 403（“禁止”）。可以重写此方法以编写自定义消息、转发或重定向到某些错误页面或登录页面，或者抛出 ServletException。
     * @param request
     * @param response
     * @param handler
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void handleNotAuthorized(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        super.handleNotAuthorized(request, response, handler);
    }

}
