package org.rola.basemvc.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author D
 * @date 2022/7/8
 * @Class RespBodyAdviceIntecp
 * @description 对控制器 响应数据 进行拦截处理或者返回数据中字段进行脱敏处理  desensitization
 */
//@Order(1)
//@ControllerAdvice(basePackages = {"org.rola.basemvc.controller"})
public class RespBodyAdviceIntecp implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return false;
    }


    /**
     * 在选择 HttpMessageConverter 之后和调用它的 write 方法之前调用
     * @param body   要写入的主体
     * @param returnType 控制器方法的返回类型
     * @param selectedContentType  通过内容协商选择的内容类型
     * @param selectedConverterType  选择写入响应的转换器类型
     * @param request  当前请求响应
     * @param response  当前响应
     * @return  传入的主体或修改的（可能是新的）实例
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 该方法测试指定的 Class 参数表示的类型是否可以通过恒等转换或扩展引用转换转换为该 Class 对象表示的类型
        boolean assignableFrom = StandardMultipartHttpServletRequest.class.isAssignableFrom(((ServletServerHttpRequest) request).getServletRequest().getClass());

        return null;
    }

    /**
     * 导出处理
     * @param obj
     * @param resp
     */
    private void exportFile(Object obj , HttpServletResponse resp) {
        String exportContent = null;
        resp.setContentType("application/octet-stream");
        resp.addHeader("Content-Disposition","attachment;filename=" + UUID.randomUUID() +".xls");
        try {
            ServletOutputStream so = resp.getOutputStream();
            assert exportContent!=null;
            so.write(exportContent.getBytes(StandardCharsets.UTF_8));
            // 刷新此缓冲输出流。这会强制将任何缓冲的输出字节写出到底层输出流。
            so.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
