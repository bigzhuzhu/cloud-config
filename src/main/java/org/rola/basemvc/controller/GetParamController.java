package org.rola.basemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author D
 * @date 2022/7/6
 * @Class GetParamController
 * @description 获取参数的方式
 */
@Controller
@RequestMapping("/getParam")
public class GetParamController {

    @RequestMapping("/param")
    public String servletParam111() {
        return "index";
    }

    /**
     * 通过 Servlet 原生API 获取参数
     *
     * @return
     */
    @RequestMapping("/servletParam")
    public String servletParam222(HttpServletRequest request) {
        // 第一次访问该方法 响应头中的Cookie 是没有 session 存在的， 访问该方法成功后 ，将 session 对象放入响应报文中返回给客户端
        // 这时 session 在每次请求中都会在请求头中的 cookie 中存在，知道浏览器关闭（会话结束）
        HttpSession session = request.getSession();


        String name = request.getParameter("name");
        //String password = request.getParameter("passsword");
        String region = request.getParameter("region");
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        String delivery = request.getParameter("delivery");
        String type = request.getParameter("type");
        String resource = request.getParameter("resource");
        String desc = request.getParameter("desc");
        System.out.println("name：" + name + "region：" + region);
        System.out.println("date1：" + date1 + "date2：" + date2);
        System.out.println("delivery：" + delivery + "type：" + type);
        System.out.println("resource：" + resource + "desc：" + desc);
        return "error/200";
    }

    @RequestMapping(value = "/paramName",method = RequestMethod.POST)
    public String mvcParam(@RequestParam("name")String name,
                          @RequestParam("region")String region,
                          @RequestParam("date1")String date1,
                          @RequestParam("date2")String date2,
                          @RequestParam("delivery")String delivery,
                          @RequestParam("type")String type,
                          @RequestParam("resource")String resource,
                          @RequestParam("desc")String desc
    ) {
        System.out.println("name：" + name + "region：" + region);
        System.out.println("date1：" + date1 + "date2：" + date2);
        System.out.println("delivery：" + delivery + "type：" + type);
        System.out.println("resource：" + resource + "desc：" + desc);
        return "error/200";
    }


    @RequestMapping(value = "/mvcParam",method = RequestMethod.POST)
    public String mvcParam(@RequestParam("name") String name,
                           @RequestParam("pass") String password,
                           @CookieValue("MUIDB") String MUIDB,
                           @CookieValue("JSESSIONID") String JSESSIONID
                           ) {
        System.out.println("name：" + name + "passsword：" + password);
        System.out.println("获取的 MUIDB：" + MUIDB);
        System.out.println("获取的 JSESSIONID：" + JSESSIONID);
        return "error/200";
    }


    /**
     * 使用实体类接受参数，传入的参数名和类中的字段名相对应
     * @return
     */
    @RequestMapping("/classParam")
    public String classParam() {
        return "error/404";
    }
}
