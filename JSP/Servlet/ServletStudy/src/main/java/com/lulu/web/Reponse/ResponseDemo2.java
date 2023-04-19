package com.luu.web.Reponse;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         ( 响应字符数据
         */
        //定义响应头的content-type为text/html且编码为charset=utf-8
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //content-type，告诉浏览器返回的数据类型是HTML类型数据，这样浏览器才会解析HTML标签
        writer.write("<h1>你好</h1>");
        /**
         * 响应字节数据
         */
//        //1. 读取文件输入流
//        FileInputStream fis = new FileInputStream("d://a.jpg");
//        //2. 获取response字节输出流
//        ServletOutputStream os = response.getOutputStream();
//        //3. 完成流的copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while ((len = fis.read(buff))!= -1){
//            os.write(buff,0,len);
//        }
//        fis.close();
//    }

        //1. 读取文件
        FileInputStream fis = new FileInputStream("d://a.jpg");
        //2. 获取response字节输出流
        ServletOutputStream os = response.getOutputStream();
        //3. 完成流的copy
        IOUtils.copy(fis,os);
        fis.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}