package com.qs.mybatis;

import com.qs.dao.UserDao;
import com.qs.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis_Test {
    private InputStream input;
    private SqlSession session;
    private UserDao mapper;
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        input = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构造器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建工厂
        SqlSessionFactory factory = builder.build(input);
        //4.创建会话对象
        session = factory.openSession();
        //5.获取代理对象
        mapper = session.getMapper(UserDao.class);
    }
    @After
    public void close() throws IOException {
        session.commit();
        session.close();
        input.close();
    }
    //查询全部信息
    @Test
    public void getAllUser1(){
        List<User> list = mapper.getAllUser();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void User1(){
        mapper.deleteUser();
    }
}
