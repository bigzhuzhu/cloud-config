package org.rola.basemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author D
 * @date 2022/7/6
 * @Class ThymeleafViewController
 * @description Thymeleaf 的三种视图解析类
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafViewController {

    @RequestMapping("/view")
    public String getView() {
        // 没有前缀使用  ThymeleafResourceView 类解析
        return "thyme_view";
    }

    /**
     * forward: 作为前缀：请求转发
     * @return
     */
    @RequestMapping("/prefixFormward")
    public String prefixFormward() {
        // 前缀 forward: 使用  InternalResourceView 类解析
        return "forward:/view";
    }

    /**
     * redirect: 作为前缀：请求重定向
     * @return
     */
    @RequestMapping("/prefixRedirect")
    public String prefixrRedirect() {
        // 前缀 redirect: 使用  RedirectThymeleafView 类解析
        return "redirect:/view";
    }
}
