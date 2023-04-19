package com.lulu03;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Test2 {
    public static void main(String[] args) throws Exception{
        //创建c3p0连接池对象
        DataSource dataSource = new ComboPooledDataSource("mysql");

        //获取数据库连接进行使用,验证连接地址
        for(int i = 1; i <= 11; i++) {
            Connection con = dataSource.getConnection();
            System.out.println(i + ":" + con);
            if(i == 5) {
                con.close();
            }
        }
    }
}


