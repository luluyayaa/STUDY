package com.luu.web.Servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/demo1")
public class SevletDemo1 implements Servlet{
    @Override
    public void service(ServletRequest req, ServletResponse servletResponse) throws ServletException, IOException {
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
