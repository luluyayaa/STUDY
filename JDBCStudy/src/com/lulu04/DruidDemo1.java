package com.lulu04;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
    Druid连接池
    1.导入jar包
    2.编写配置文件，放在src目录下
    3.通过Properties集合加载配置文件
    4.通过Druid连接池工厂类获取数据库连接池对象
    5.获取数据库连接，进行使用
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception{
        //通过Properties集合加载配置文件
        Connection con = DataSourceUtils.getConnection();
        //查询全部学生信息
        String sql = "SELECT * FROM bkinfo";
        PreparedStatement pst = con.prepareStatement(sql);
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
        DataSourceUtils.close(con,pst,rs);
    }
}

