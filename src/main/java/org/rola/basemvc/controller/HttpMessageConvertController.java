package org.rola.basemvc.controller;

import org.rola.basemvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author D
 * @date 2022/7/7
 * @Class HttpMessageConvert
 * @description 报文信息转化器， 将请求报文转为 Java对象，或将 Java 对象转换为响应报文
 *  两个注解和两个类型：
 * @RequestBody: 获取请求体中的参数
 * @ResponseBody
 * RequestEntity：获取整个请求报文（请求头  请求空行  请求体）  getHeader()   getBody()
 * ResponseEntity：响应报文 给客户端
 */
@Controller
@RequestMapping("/msgCovert")
public class HttpMessageConvertController {


    @DeleteMapping ("/reqBody")
    public String  reqBody(@RequestBody String requestBody) {
        System.out.println("@RequestBody  接受的 post 请求体中参数：" + requestBody);
        return "error/200";
    }

    @PutMapping ("/reqEntity")
    public String reqEntity(RequestEntity requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        System.out.println("requestEntity 接受 post 请求中请求头：" + headers);
        Object body = requestEntity.getBody();
        System.out.println("requestEntity 接受 post 请求中请求体：" +body);
        return "error/200";
    }


    /**
     * @ResponseBody  将 Java 对象 作为返回值返回，转换为 Json 字符串作为响应体响应到客户端
     * 1 引入  jackson-databind  jar  包
     * 2 开启    <mvc:annotation-driven/>
     * 3 @ResponseBody
     * @return
     */
    @RequestMapping("/respBody")
    @ResponseBody
    public User respBody() {
        User user = new User(1,"Jack陈",32,30000);
        return user;
    }
}
