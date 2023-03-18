/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Nguyen Hoang Minh
 */
@WebServlet(urlPatterns = "/first")
public class FirstDynamicWebpage extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        resp.getWriter().println("<h1 style='color: red;'>Hello "+name+" "+age+"</h1>");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        resp.getWriter().println("<h1 style='color: red;'>Hello "+name+" "+age+"</h1>");
    }
    
}
