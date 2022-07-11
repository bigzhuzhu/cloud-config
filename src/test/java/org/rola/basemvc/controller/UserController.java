package org.rola.basemvc.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.rola.basemvc.mapper.BlogUserMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author D
 * @date 2022/7/11
 * @Class UserController
 * @description TODO
 */

public class UserController {
    @Test
    public void testUser() throws IOException {
        // 加载 mybatis 配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获得 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        // 获得 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sfb.build(is);
        // 获得 SqlSession ：java 程序和 数据库之间的会话，类比  http 中的 session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过代理模式获得 mapper 接口的实现类
        BlogUserMapper mapper = sqlSession.getMapper(BlogUserMapper.class);
        int re = mapper.addBlogUser();
        // 手动提交事务，false  不自动提交事务， true 自动提交事务
        sqlSession.commit();
        System.out.println("result：" + re);
    }
}
