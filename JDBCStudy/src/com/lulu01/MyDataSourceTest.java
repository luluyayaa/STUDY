package com.lulu01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyDataSourceTest {
    public static void main(String[] args) throws Exception {
        //创建连接池对象
        MyDataSource dataSource = new MyDataSource();
        System.out.println("使用之前的数量" + dataSource.getSize());
        //获取连接对象
        Connection conn = dataSource.getConnection();
        System.out.println(conn.getClass());
        //查询表信息
        String sql = "SELECT * FROM bkinfo";
        PreparedStatement pst = conn.prepareStatement(sql);
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
        //释放资源
        rs.close();
        pst.close();
        conn.close();
        System.out.println("使用之后的数量" + dataSource.getSize());

    }
}
