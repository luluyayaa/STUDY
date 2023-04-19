package com.luluTpl;

import com.luluTpl.domain.Book;
import com.luluTpl.hander.BeanHandler;
import com.luluTpl.hander.BeanListHandler;
import com.luluTpl.hander.ScalarHandler;
import com.utils.DataSourceUtils;
import org.testng.annotations.Test;

import java.util.List;

public class JDBCTemplateTest {
    //创建JDBCTemplate对象
    JDBCTemplate template = new JDBCTemplate(DataSourceUtils.getDataSource());

    @Test
    public void selectScalar() {
        //查询student表的记录条数
        String sql = "SELECT COUNT(*) FROM bkinfo";
        Long count = template.queryForScalar(sql, new ScalarHandler<Long>());
        System.out.println(count);
    }

    @Test
    public void selectAll() {
        //查询所有学生信息
        String sql = "SELECT * FROM bkinfo";
        List<Book> list = template.queryForList(sql, new BeanListHandler<Book>(Book.class));
        for(Book bk : list) {
            System.out.println(bk);
        }
    }

    @Test
    public void selectOne() {
        //查询记录
        String sql = "SELECT * FROM bkinfo WHERE bkId=?";
        //通过BeanHandler将结果封装成一个Student对象
        Book bk = template.queryForObject(sql, new BeanHandler<Book>(Book.class), 1);
        System.out.println(bk);
    }

    @Test
    public void insert() {
        String sql = "INSERT INTO bkinfo VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {15,"天空之城","宫崎骏","日本","文学",50,100,"null","1","在售","a" };
        int result = template.update(sql,params);
        if (result == 0) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

    }
    @Test
    public void update() {
        String sql = "UPDATE bkinfo SET bkType=? WHERE bkName=?";
        Object[] params = {"小说","天空之城" };
        int result = template.update(sql,params);
        System.out.println(result);

    }
    @Test
    public void delete(){
        String sql = "DELETE FROM bkinfo WHERE bkName=?";
        int result = template.update(sql,"天空之城");
        System.out.println(result);

    }
}

