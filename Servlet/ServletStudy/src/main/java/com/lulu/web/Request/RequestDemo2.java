package com.luu.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * request 通用方式获取请求参数
 */
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
        System.out.println("get....");
        //1. 获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            // username:zhangsan lisi
            System.out.print(key + ":");
            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println("");
        }
            System.out.println("_______");
            /**
             * 获取GET请求参数中的爱好，结果是数组值
             */

            String[] hobbies = req.getParameterValues("hobby");
            for (String hobby : hobbies) {
                System.out.println(hobby);
            }
            /**
             *获取GET请求参数中的用户名和密码，结果是单个值
             */
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username);
            System.out.println(password);
        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}