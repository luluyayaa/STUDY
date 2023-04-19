package com.lululayer.controller;

import com.lululayer.domain.Book;
import com.lululayer.service.BookService;
import com.lululayer.service.BookServicelmpl;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookController {
    private BookService service = new BookServicelmpl();
    /**
     * 查询所有学生信息
     */
    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Book> list = service.findAll();
        for (Book bk : list) {
            System.out.println(bk);
        }
    }

    /**
     * 条件查询，根据id查询学生信息
     */
    @Test
    public void findById() throws SQLException {
        Book bk = service.findById(2);
        System.out.println(bk);
    }

    @Test
    public void insert() throws SQLException {
        Book bk = new Book(13,"天空之城","宫崎骏","日本","文学",50,100,new Date(),"1","在售","a");
        int result = service.insert(bk);
        if (result != 0) {
            System.out.println("添加成功！");

        }else {
            System.out.println("添加失败");
        }
    }
    @Test
    public void update() throws SQLException {
        Book bk = service.findById(13);
        bk.setBkName("aaa");
        int result = service.update(bk);
        if (result != 0) {
            System.out.println("修改成功！");

        } else {
            System.out.println("修改失败");
        }
    }


    @Test
    public void delete() throws SQLException {
        int result = service.delete(13);
        if (result != 0) {
            System.out.println("删除成功！");

        } else {
            System.out.println("删除失败");
        }

    }

}
