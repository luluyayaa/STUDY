package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    //私有构造方法
    private JdbcUtils() {
    }
    // 声明需要的配置变量
    private  static  String driverClass ;
    private  static  String url;
    private  static  String username;
    private  static  String password;
    private static  Connection con;

    //静态代码块，读取配置文件的信息为变量赋值注册驱动
     static {
        try {
            //读取配置文件的信息为变量赋值
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(is);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //注册驱动
            Class.forName(driverClass);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
     }

//提供获取数据库
public static Connection getConnection() {
    try {
        con = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return con;
}
    //释放资源的方法
public static void close(Connection con, Statement stat, ResultSet rs)  {
         if(con != null){
             try {
                 con.close();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
    if(stat != null){
        try {
            stat.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    if(rs != null){
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

//close重载没有rs的情况
    public static void close(Connection con, Statement stat)  {
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}