package org.rola.basemvc.resolver;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author D
 * @date 2022/7/7
 * @Class AnnoExceptionResolver
 * @description @ControllerAdvice 纳入springIOC 容器中管理即可
 * 基于注解的 异常处理器  @ExceptionHandler
 */
// @ControllerAdvice //(basePackages = "org.rola.basemvc.controller")
public class AnnoExceptionResolver  {

    /**
     * 异常处理方法
     * @param ex  出现的异常类型
     * @param model  将异常信息放入 Model 域中，方便异常页面获取展示异常信息
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String customEx(Exception ex, Model model) {
        model.addAttribute("ex",ex);
        return "error/except";
    }

}
