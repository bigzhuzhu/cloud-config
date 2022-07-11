package org.rola.basemvc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author D
 * @date 2022/7/11
 * @Class RequestListener
 * @description 监听器：用于监听servletContext、HttpSession和 servletRequest 等域对象的创建和销毁事件
 * 用途：
 *      1. 统计在线人数和在线用户
 *      2. 系统启动时加载初始化信息
 *      3. 统计网站访问量
 *      4. 记录用户访问路径...
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("======销毁监听器========");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("======进入监听器========");

    }
}