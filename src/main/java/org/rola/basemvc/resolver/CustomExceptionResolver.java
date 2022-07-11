package org.rola.basemvc.resolver;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @author D
 * @date 2022/7/7
 * @Class HandlerExceptionResolver 是 SpringMVC 异常处理器
 * @description 自定义异常处理器：为控制器方法出现异常做处理，如： extends SimpleMappingExceptionResolver
 *
 */
//@ControllerAdvice("org.rola.basemvc.controller")
public class CustomExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    public void setExceptionMappings(Properties mappings) {
        // 参数一  处理控制器中出现的异常的全类名    参数二 出现异常后，跳转的异常视图名称
        mappings.setProperty("java.lang.ArithmeticException","error/except");
        super.setExceptionMappings(mappings);
    }

    /**
     * 自定义异常页面上的内容，默认存储在请求域中
     * @param exceptionAttribute
     */
    @Override
    public void setExceptionAttribute(String exceptionAttribute) {
        // ex   存储在请求域中错误异常信息的键，将域中异常信息共享
        exceptionAttribute = "ex";
        super.setExceptionAttribute(exceptionAttribute);
    }
}
