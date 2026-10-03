package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        // 1. Nhận thông tin đăng nhập gửi từ form HTML
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        // 2. Xử lý logic và phản hồi HTML
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Login Result</title></head>");
            out.println("<body style='font-family: Arial, sans-serif; text-align: center; margin-top: 100px;'>");
            
            if ("admin".equals(user) && "admin".equals(pass)) {
                out.println("<h1 style='color: green;'>Welcome admin to website</h1>");
            } else {
                out.println("<h1 style='color: red;'>Login Error</h1>");
            }
            
            out.println("<br><br><a href='index.jsp' style='text-decoration: none; color: #1b2a7a; font-weight: bold;'>Go back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
