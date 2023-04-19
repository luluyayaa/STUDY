package com.lululayer.service;

import com.lululayer.dao.BookDao;
import com.lululayer.dao.BookDaolmpl;
import com.lululayer.domain.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookServicelmpl implements BookService {
    //多态
    private BookDao dao = new BookDaolmpl();
    /**
     *查询学生信息
     */
    @Override
    public ArrayList<Book> findAll() throws SQLException, ClassNotFoundException {
        return dao.findAll();
    }

    /**
     *查询学生信息
     */
    @Override
    public  Book findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    /**
     *  //新增学生信息
     * @param bk
     * @return
     * @throws SQLException
     */
    @Override
    public int insert(Book bk) throws SQLException {
        return dao.insert(bk);
    }

    /**
     * 更改学生信息
     * @param bk
     * @return
     * @throws SQLException
     */
    @Override
    public  int update(Book bk) throws SQLException{
        return dao.update(bk);
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) throws SQLException {
        return dao.delete(id);
    }
}
