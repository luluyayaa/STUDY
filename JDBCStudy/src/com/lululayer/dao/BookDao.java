package com.lululayer.dao;

import com.lululayer.domain.Book;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Dao层接口
 */
public interface BookDao {
    /**
     *   查询所有学生信息
     */
    ArrayList<Book> findAll() throws SQLException, ClassNotFoundException;


    Book findById(Integer id) throws SQLException;


    int insert(Book bk) throws SQLException;

    //更改学生信息
    int update(Book bk) throws SQLException;

    int delete(Integer id) throws SQLException;
}
