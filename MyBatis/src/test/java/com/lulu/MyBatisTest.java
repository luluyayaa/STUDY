package com.lulu;

import com.lulu.util.SqlSessionFactoryUtils;
import com.lulu.pojo.Book;
import com.lulu.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        //2. 获取SqlSession对象
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        List<Book> book = bookMapper.selectAll();//写着一行就行
        System.out.println(book);
        //5. 释放资源
        sqlSession.close();

    }
    @Test
    public void testSelectById() throws IOException {
        int bkId =1;
        //获取SqlSessinFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        Book book = bookMapper.selectById(bkId);//写着一行就行
        System.out.println(book);
        //5. 释放资源
        sqlSession.close();

    }
    @Test
    public void testSelectByCondition() throws IOException {
        String bkName = "悉";
        String bkType = "";
        bkName = "%"+bkName+"%";
        bkType = "%"+bkType+"%";
        //获取SqlSessinFactory
        //封装对象
//            Book inputbk = new Book();
//            inputbk.setBkType(bkType);
//            inputbk.setBkName(bkName);
        Map map = new HashMap();
        map.put("bkName",bkName);
        map.put("bkType",bkType);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        //List<Book> book = brandMapper.selectByCondition(bkType,bkName);//写着一行就行
        //List<Book> book = brandMapper.selectByCondition(inputbk);
        List<Book> book = bookMapper.selectByCondition(map);
        System.out.println(book);
        //5. 释放资源
        sqlSession.close();

    }
    @Test
    public void testSelectBySingleCondition() throws IOException {
        //String bkName = "悉达多";
        //String bkType = "";
        //bkName = "%"+bkName+"%";
        //bkType = "%"+bkType+"%";

        Book inputbk = new Book();
        //inputbk.setBkType(bkType);
        //inputbk.setBkName(bkName);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> book = bookMapper.selectBySingleCondition(inputbk);
        System.out.println(inputbk);
        //5. 释放资源
        sqlSession.close();
    }
    @Test
    public void testAdd() throws IOException {
        //获取SqlSessinFactory
        String bkName = "aaa";
        String bkAuthor = "aaa";
        String bkCountry = "aaa";
        String bkType = "aaa";
        Integer bkPrice = 20;
        Integer bkStockNum = 5;
        String bkSellDate ="2000-10-14";
        //封装对象
        Book book = new Book();
        book.setBkName(bkName);
        book.setBkAuthor(bkAuthor);
        book.setBkCountry(bkCountry);
        book.setBkType(bkType);
        book.setBkPrice(bkPrice);
        book.setBkStockNum(bkStockNum);
        book.setBkSellDate(bkSellDate);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//关闭事务
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        bookMapper.add(book);//写着一行就行
        System.out.println(book);
        //5. 释放资源
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws IOException {
        //获取SqlSessinFactory
        Integer bkId = 134;
        String bkName = "eafv";
        String bkAuthor = "bbb";
        String bkCountry = "aaa";
        String bkType = "aaa";
        Integer bkPrice = 20;
        Integer bkStockNum = 5;
        String bkSellDate = new String();
        String bkPicName = "a";
        String bkStatus = "在售";
        String bkDesc = " ";
        //封装对象
        Book book = new Book();
        book.setBkId(bkId);
        book.setBkName(bkName);
//        book.setBkAuthor(bkAuthor);
//        book.setBkCountry(bkCountry);
//        book.setBkType(bkType);
        book.setBkPrice(bkPrice);
        book.setBkStockNum(bkStockNum);
        book.setBkSellDate(bkSellDate);
        book.setBkPicName(bkPicName);
        book.setBkStatus(bkStatus);
        book.setBkDesc(bkDesc);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//关闭事务
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        int count = bookMapper.update(book);//写着一行就行
        System.out.println(count);
        //5. 释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteById() throws IOException {
        int bkId = 13;
        //获取SqlSessinFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        bookMapper.deleteById(bkId);//写着一行就行
        //5. 释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteByIds() throws IOException {
        int[] bkIds = {16,17};
        //获取SqlSessinFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4. 执行方法
        bookMapper.deleteByIds(bkIds);//写着一行就行
        //5. 释放资源
        sqlSession.close();
    }
}
