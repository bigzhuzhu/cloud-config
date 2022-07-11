package org.rola.basemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author D
 * @date 2022/7/7
 * @Class JspContextController
 * @description JSP 视图解析器
 */
@Controller
public class JspContextController {
    /**
     * 创建两种视图解析类
     *  1. 不带前缀/ 前缀 forward: 的都是 InternalResourceView
     *  2. 前缀  redirect:  是 RedirectView
     * @return
     */
    @RequestMapping("/pageContext")
    public String getJspSuc() {
        return "pageContext";
    }
}
