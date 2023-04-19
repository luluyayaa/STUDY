package com.lulu02;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.Connection;
import java.util.List;


/**
 * 继承模式自定义连接对象
 * 定义一个类，继承Connection
 * 定义Connection连接对象和容器对象的成员变量
 * 通过有参构造方法为成员变量赋值
 * 重写close归还连接
 */
public class MyConnection1 extends ConnectionImpl {
    //定义Connection连接对象和容器对象的成员变量
    private Connection con;
    private List<Connection>pool;
//通过有参构造方法为成员变量赋值
    public MyConnection1(Connection con,List<Connection> pool) {
        this.con = con;
        this.pool = pool;
    }
    @Override
    /**
     *   重写close归还连接,继承无法完成
     * ，通过查看JDBC工具类获取连接的方法我们发现：
     * 我们虽然自定义了一个子类，完成了归还连接的操作。但是DriverManager获取的还是JDBC4Connection这个对象，
     * 并不是我们的子类对象。而我们又不能整体去修改驱动包中类的功能
     */
    public void close(){
    }
}
