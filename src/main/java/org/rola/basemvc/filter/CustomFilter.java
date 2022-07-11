package org.rola.basemvc.filter;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author D
 * @date 2022/7/6
 * @Class CharsetFilter
 * @description 自定义一个 Filter extends HttpFilter/GenericFilter...等等  只需要重写  doFilter 方法即可
 *
 *  通过ServletRequest得到HttpServletRequest,此时你就可以对请求或响应(Request、Response)那就可以对对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。例如：
 * 用途：
 *      1. 实现URL级别的权限访问控制
 *      2. 过滤敏感词汇
 *      3. 压缩响应信息
 *      4. 字符集统一等
 */
@WebFilter(urlPatterns = "/static/js/img/*",servletNames = "CustomFilter")
public class CustomFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("自定义 CustomFilter 过滤器执行方法");
        String uri = ((HttpServletRequest)request).getRequestURI();
        System.out.println("自定义 CustomFilte request URI:" + uri);
        if(uri.contains("/img")) {
            ((HttpServletResponse)response).sendRedirect("http:localhost:8080/mvcweb/vueForm");
        }else {
            chain.doFilter(request, response);
        }
    }

    /**
     * 在自定义的 FIlter 中，定义一个静态内部类继承  HttpServletRequestWrapper  实现自己想写的内容 CustomServlet
     */
    private static class CustomServlet extends HttpServletRequestWrapper {

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request the {@link HttpServletRequest} to be wrapped.
         * @throws IllegalArgumentException if the request is null
         */
        public CustomServlet(HttpServletRequest request) {
            super(request);
            String uri = request.getRequestURI();

            System.out.println("自定义 CustomServlet request URI:" + uri);
        }


    }
}
