package com.lulu03;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.utils.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
使用C3P0连接池
1.导入jar包
2.导入配置文件到src目录下
3.创建c3p0连接池对象
4.获取数据库连接进行使用
*/
public class C3P0Test3 {
    public static void main(String[] args) throws Exception{
        //创建c3p0连接池对象
        DataSource dataSource = new ComboPooledDataSource("mysql");

        //获取数据库连接进行使用
        Connection con = JdbcUtils.getConnection();

        //查询表信息
        String sql = "SELECT * FROM bkinfo";
        PreparedStatement pst = con.prepareStatement(sql);
        //执行语句返回结果集
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("bkid") + "\t" +
                    rs.getString("bkName") + "\t" +
                    rs.getString("bkAuthor") + "\t" +
                    rs.getString("bkCountry") + "\t" +
                    rs.getString("bkType") + "\t" +
                    rs.getInt("bkPrice") + "\t" +
                    rs.getInt("bkStockNum") + "\t" +
                    rs.getDate("bkSellDate") + "/\t" +
                    rs.getString("bkPicName") + "\t" +
                    rs.getString("bkStatus") + "\t" +
                    rs.getString("bkDesc") + "\t");
        }
        //释放

        //释放资源
        rs.close();
        pst.close();
        con.close();    // 将连接对象归还池中
    }
}

