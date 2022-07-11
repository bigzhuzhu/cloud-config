package org.rola.basemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author D
 * @date 2022/7/6
 * @Class RequestScopeController
 * @description 向 request 域对象中存储数据的五种方式 ，推荐使用 ModelAndView
 */
@Controller
@RequestMapping("/scope")
public class RequestScopeController {

    /**
     * 使用 Servlet 向 request 域对象中存储数据
     * @param req
     * @return
     */
    @RequestMapping("/servletScope")
    public String getServletScope(HttpServletRequest req) {
        System.out.println("servletScope");
        req.setAttribute("testScopeData","Servlet 存储数据");
        return "scope";
    }

    /**
     * 使用 ModelAndView 向域对象中存储数据
     * springMVC 推荐使用 ModelAndView ，因为 HttpServletRequest model  map  modelMap 最终都会封装为 ModelAndView
     * @param
     * @return
     */
    @RequestMapping("/mvcScope")
    public ModelAndView mvcScope() {
        System.out.println("mvcScope");
        ModelAndView view = new ModelAndView();
        // 向请求域中共享数据
        view.addObject("testScopeData","ModelAndView 存储数据");
        // 设置视图，跳转页面
        view.setViewName("scope");
        return view;
    }


    @RequestMapping("/modelScope")
    public String modelScope(Model model) {
        // 向请求域中共享数据
        model.addAttribute("testScopeData","Model 存储数据");
        return "scope";
    }

    @RequestMapping("/modelMapScope")
    public String modelMapScope(ModelMap modelMap) {
        // 向请求域中共享数据
        modelMap.addAttribute("testScopeData","modelMap 存储数据");
        return "scope";
    }

    @RequestMapping("/mapScope")
    public String mapScope(Map map) {
        // 向请求域中共享数据
        map.put("testScopeData","Map 存储数据");
        return "scope";
    }

    /**
     * 向 session 域存储数据
     * @param req
     * @return
     */
    @RequestMapping("/sessionScope")
    public String sessionScope(HttpServletRequest req) {
        // 向 session域中共享数据
        HttpSession session = req.getSession();
        session.setAttribute("testSessionScope","session scope transform data");
        return "scope";
    }

    /**
     * 向 servletContext 域存储数据
     * @param req
     * @return
     */
    @RequestMapping("/contextScope")
    public String contextScope(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("testContextScope","context scope transform data");
        return "scope";
    }
}
