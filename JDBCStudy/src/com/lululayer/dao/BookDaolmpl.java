package com.lululayer.dao;


import com.lululayer.domain.Book;
import com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BookDaolmpl implements BookDao {
    /**
     *查询学生信息
     */
    @Override
    //查询所有学生信息
    public  ArrayList<Book> findAll() throws SQLException, ClassNotFoundException {
        //创建集合封装返回的结果集
        ArrayList<Book> list = new ArrayList<Book>();
        //实例化工具类
        Connection con = JdbcUtils.getConnection();
//    获取执行对象实例化statement
        Statement stat = con.createStatement();
        //执行操作获取结果
        String sql = "SELECT * FROM bkinfo";
        ResultSet rs = stat.executeQuery(sql);
        //处理结果集
        while (rs.next()) {
            Integer bkId = rs.getInt("bkId");
            String bkName = rs.getString("bkName");
            String bkAuthor = rs.getString("bkAuthor");
            String bkCountry = rs.getString("bkCountry");
            String bkType =rs.getString("bkType");
            Integer bkPrice = rs.getInt("bkPrice");
            Integer  bkStockNum =rs.getInt("bkStockNum");
            Date bkSellDate = rs.getDate("bkSellDate");
            String bkPicName = rs.getString("bkPicName");
            String bkStatus = rs.getString("bkStatus");
            String bkDesc = rs.getString("bkDesc");
            //对象封装
            Book bk = new Book(bkId,bkName,bkAuthor,bkAuthor,bkType,bkPrice,bkStockNum,bkSellDate,bkPicName,bkStatus,bkDesc);
            //对象保存到集合
            list.add(bk);
            System.out.println(rs);
//            JdbcUtils.close(con,stat,rs);
        }
        return list;
    }


    //条件查询，根据id获取学生信息
    public  Book findById(Integer id) throws SQLException {
        Book bk = new Book();
        Connection con = JdbcUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "SELECT * FROM bkinfo WHERE bkId = '"+id+"'";
        System.out.println(sql);
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            Integer bkId = rs.getInt("bkId");
            String bkName = rs.getString("bkName");
            String bkAuthor = rs.getString("bkAuthor");
            String bkCountry = rs.getString("bkCountry");
            String bkType = rs.getString("bkType");
            Integer bkPrice = rs.getInt("bkPrice");
            Integer bkStockNum = rs.getInt("bkStockNum");
            Date bkSellDate = rs.getDate("bkSellDate");
            String bkPicName = rs.getString("bkPicName");
            String bkStatus = rs.getString("bkStatus");
            String bkDesc = rs.getString("bkDesc");
            //封装对象
            bk.setBkId(bkId);
            bk.setBkName(bkName);
            bk.setBkAuthor(bkAuthor);
            bk.setBkCountry(bkCountry);
            bk.setBkType(bkType);
            bk.setBkPrice(bkPrice);
            bk.setBkStockNum(bkStockNum);
            bk.setBkSellDate(bkSellDate);
            bk.setBkPicName(bkPicName);
            bk.setBkStatus(bkStatus);
            bk.setBkDesc(bkDesc);
        }
        return bk;
    }

    //新增学生信息
    public int insert(Book bk) throws SQLException {
        int result = 0;
        Connection con = JdbcUtils.getConnection();
        Statement stat = con.createStatement();
        //日期格式化
        Date d  = bk.getBkSellDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bkSellDate = sdf.format(d);
        String sql = "INSERT INTO bkinfo VALUES ('"+bk.getBkId()+"','"+bk.getBkName()+"','"+bk.getBkAuthor()+"','"+bk.getBkCountry()+"','"+bk.getBkType()+"','"+bk.getBkPrice()+"','"+bk.getBkStockNum()+"','"+bkSellDate+"','"+bk.getBkPicName()+"','"+bk.getBkStatus()+"','"+bk.getBkDesc()+"')";
        result = stat.executeUpdate(sql);
        return result;
    }

    @Override
    public int update(Book bk) throws SQLException {
        int result = 0;
        Connection con = JdbcUtils.getConnection();
        Statement stat = con.createStatement();
        //日期格式化
        Date d  = bk.getBkSellDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bkSellDate = sdf.format(d);
        String sql = "UPDATE bkinfo SET bkId='"+bk.getBkId()+"',bkName='"+bk.getBkName()+"',bkAuthor='"+bk.getBkAuthor()+"',bkCountry='"+bk.getBkCountry()+"',bkType='"+bk.getBkType()+"',bkPrice='"+bk.getBkPrice()+"',bkStockNum='"+bk.getBkStockNum()+"',bkSellDate='"+bkSellDate+"',bkPicName='"+bk.getBkPicName()+"',bkStatus='"+bk.getBkStatus()+"',bkDesc='"+bk.getBkDesc()+"' WHERE bkId='"+bk.getBkId()+"'";
        result = stat.executeUpdate(sql);
        return result;
    }

    //删除学生信息
    public int delete(Integer id) throws SQLException {
        int result = 0;
        Connection con = JdbcUtils.getConnection();
        Statement stat = con.createStatement();
        //日期格式化
        String sql = "DELETE FROM bkinfo WHERE bkId='"+id+"'";
        result = stat.executeUpdate(sql);
        return result;
    }
    }

