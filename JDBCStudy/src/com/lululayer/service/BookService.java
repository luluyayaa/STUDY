package com.lululayer.service;

import com.lululayer.domain.Book;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Service层接口
 */
public interface BookService {
    //查询所有学生信息
    ArrayList<Book> findAll() throws SQLException, ClassNotFoundException;

    //条件查询，根据id获取学生信息
    Book findById(Integer id) throws SQLException;

    //新增学生信息
    int insert(Book bk) throws SQLException;

    //更改学生信息
    int update(Book bk) throws SQLException;

    //删除学生信息
    int delete(Integer id) throws SQLException;
}
