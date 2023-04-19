package com.lulu.service;

import com.lulu.pojo.Book;
import com.lulu.mapper.BookMapper;
import com.lulu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.annotations.Test;

import java.util.List;


/**
 * mybatis 代理开发
 */
@Test
public class BookService {
    //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
      public List<Book> selectAll() {
          //2. 获取SqlSession对象，用它来执行sql
          SqlSession sqlSession = factory.openSession();
          //3. 执行sql
          //参数是一个字符串，该字符串必须是映射配置文件的namespace.id
          //List<Book> book = sqlSession.selectList("test.selectAll");
          //获取mapper代理对象
          BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
          List<Book> books = bookMapper.selectAll();
          System.out.println(books);
          //4. 释放资源
          sqlSession.close();
          return null;
      }

}
