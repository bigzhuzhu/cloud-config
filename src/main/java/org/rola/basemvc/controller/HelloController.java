package org.rola.basemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D
 * @date 2022/7/5
 * @Class HelloController
 * @description TODO
 * 浏览器发送请求，若请求地址符合前端控制器的 url-pattern， 该请求会被前端控制器 DispatcherServlet 处理，前端控制器会读取
 * springMVC.xml (SpringMVC 的配置文件，随便命名)，通过扫描组件找到控制器，将请求地址和控制器(@Controller)中
 * @RequestMapping("/login") 的 value 进行匹配，若匹配成功，该注解所对应的方法就是处理请求的方法，返回一个字符串类型的视图名称，
 * 该视图名称会被 springMVC.xml 中配置的视图解析器解析，加上前缀和后缀组成视图的路径，通过 Thymeleaf 对视图进行渲染，
 * 最终转发（不是重定向）到视图所对应的页面
 */
@Controller
public class HelloController {

    // 请求映射 ,
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    // 请求映射
    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    /**
     * 占位符常用于 restful 风格中，请求中通过路径的方式传递参数给服务端
     * 通过占位符 /path/{xxx}/{xxx} 表示传输的数据
     * 再通过 @PathVariable 获取占位符传递的参数
     * @return
     */
    @RequestMapping("/login/{id}/{username}")
    public String paramOfLogin(@PathVariable("id") Integer id,@PathVariable("username") String username) {
        System.out.println("id:" + id + "username:"+username);
        return "login";
    }

    @RequestMapping("/testExcpt")
    public void testExcpt() {
       int i = 10 / 0;
    }

}
