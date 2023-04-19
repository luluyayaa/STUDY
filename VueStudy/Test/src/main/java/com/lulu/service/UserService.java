package com.lulu.service;

import com.lulu.mapper.UserMapper;
import com.lulu.pojo.User;
import com.lulu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.awt.print.Book;
import java.util.List;

public class UserService {
    //1.使用工具类获取SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<User> selectAll(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession(true);
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.selectAll();
        sqlSession.close();
        return user;
    }
    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    public User login(String name, String password) {
        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.select(name, password);
        //释放资源
        sqlSession.close();

        return  user;
    }
    /**
     * 注册方法
     * @return
     */
    public void register(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession(true);
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 注册
        mapper.add(user);
        sqlSession.close();
    }
}
