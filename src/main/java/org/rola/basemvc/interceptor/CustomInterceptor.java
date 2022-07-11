package org.rola.basemvc.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author D
 * @date 2022/7/7
 * @Class CustomInterceptor
 * @description 拦截器：implements HandlerInterceptor，处理 Controller 控制器中的方法，对控制器中的方法执行 前后进行处理
 * 三种拦截器：
 *  1. 控制器的方法前处理
 *  2. 控制器的方法后处理
 *  3. 控制器方法执行完，并且 ModelAndView 执行完了后处理
 *
 *  多个拦截器， preHandle()（i++） 按照  springMVC.xml 配置的拦截器顺序执行
 *            postHandle()（i--）和 afterCompletion (i--) 按照配置的相反顺序执行
 *
 *  当多个拦截器中， 其中某个  preHandle() 返回 false(拦截) ，preHandler() 按照配置的顺序执行到返回  false 的拦截器（包括这个 false 的拦截器），
 *                  postHandle() 不会有任何拦截器执行，afterCompletion() 由返回false 之前的拦截器（不包括这个 false 的拦截器）继续执行
 */
@Order(1)  // 拦截器执行顺序  值越小，先执行
@ControllerAdvice
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // false  拦截   ，true  放行
        System.out.println("preHandle --->  preHandle Controller");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle --->  postHandle Controller");
    }

    /**
     * 视图渲染之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion --->  afterCompletion ModelAndView");
    }
}
