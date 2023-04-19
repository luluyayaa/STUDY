package com.lulu.web;

import com.alibaba.fastjson.JSON;
import com.lulu.pojo.User;
import com.lulu.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author lulu
 */
@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 注意处理POST请求的乱码问题
         */
        request.setCharacterEncoding("utf-8");
        //获取请求体中的JSON
        BufferedReader ur= request.getReader();
        String params = ur.readLine();
        // 将JSON字符串转为Java对象
        User user = JSON.parseObject(params, User.class);
        //2. 调用service 添加
        service.register(user);
        //3. 响应成功的标识
        response.getWriter().write("success");
        //将登陆成功后的user对象，存储到session
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/quiz.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}