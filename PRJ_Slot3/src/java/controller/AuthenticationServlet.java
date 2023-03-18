/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals(this.getInitParameter("username"))
                && password.equals(this.getInitParameter("password"))) {
            resp.getWriter().println("login successful!");

        } else {
            resp.getWriter().println("access denied");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.html").forward(req, resp);
        String username = this.getInitParameter("username");
        String password = this.getInitParameter("password");
        String global = this.getServletContext().getInitParameter("globalparam");
        resp.getWriter().println(username + " " + password + " " + global);
    }

}
