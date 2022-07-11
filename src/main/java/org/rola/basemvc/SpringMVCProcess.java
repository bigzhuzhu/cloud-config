package org.rola.basemvc;

import org.springframework.stereotype.Repository;

/**
 * @author D
 * @date 2022/7/10
 * @Class SpringMVCProcess
 * @description SpringMVC 整个执行流程
 */
public class SpringMVCProcess {


    /**
     *  SpringMVC的执行流程
     * 1）用户向服务器发送请求，请求被SpringMVC 前端控制器 DispatcherServlet捕获。
     * 2)DispatchefServlet 对请求URL进行解析，得到请求资源标识符(URI)，判断请求URI对应的映射：
     * a)不存在
     * 1. 再判断是否配置了 mvc:default-servlet-handler
     *
     * 2. 如果没配置，则控制台报映射查找不到，客户端展示404错误
     * DEBUG org. springframework.web.servlet.Dispatcherservlet-Completed 404 NOT FOUND
     *
     * 3. 如果有配置，则访问目标资源（一般是静态资源html,css,js），找不到客户端也会显示404错误
     *  org. springframework.web.servlet.resource.DefaultServletHandler
     *
     * b)存在
     * 3)根据该URI，洞用HandlerMapping获得该Handler配置的所有相关的对象（包括Handler对象以及Handler对象
     * 对应的拦截器）
     * 最后以HandlerExecutionChain执行链对象的形式返回，
     * 4) Dispatcherservlet 根据获得的Handler，选择一个合适的 HandlerAdapter
     * 5)如果成功获得HandlerAdapter，此时将开始执行拦截器的preHandler(.)方法【正向顺序执行  i++〕，再通过 HandlerAdapter 调用到Controller 中对应的方法
     * 6) 提取Request中的模型数据，填充Handler（控制器中映射的方法）入参，开始执行Handler(Controller)方法，处理请求。在填充
     * Handler的入参过程中，根据你的配置，Spring 会做一下额外的工作：
     *      a)HttpMessageconveter：将请求消息 (如son、xm!等数据）转换成一个对家，将对家转换为指定的响应信息
     *      b)数据转化：对请木消息进行数据转项，如String转顶成inreger Double等
     *      c)数据格式化：对请求消息进行数据格式化。如将字符串转涣成格式化效字或格式化日期等
     *      d)数据验证：验证数据的有效性（长度、格式等），验证结果存储到BindingResult或Error中
     * 7)Handler执行完成后，向 Dispatcherservlet 返回一个（不管Controller中的方法返回的是 Model，Map，ModelMap...最终都是转化为ModelAndView类型）ModelAndView对象。
     * 8)此时将开始执行拦截品的 postHandle(…)【逆向的顺序】（i--），
     * 9)根据返回的ModelAndview(此时会判断是否存在异常 processDispatchResult()：如果存在异常，则执行HandlerExceptionResolver进
     * 行异常处理）选择一个适合的 ViewResolver（如： ThymeleafResourceView ，InternalResourceView，RedirectThymeleafView） 进行视图解析，根据Model和View，来渲染视图。
     * 10)渣染视图完毕执行拦截器的 afterCompletion(..)方法【逆向的顺序】（i--）
     * 11)将渲染结果返回给客户端。
     */
}
