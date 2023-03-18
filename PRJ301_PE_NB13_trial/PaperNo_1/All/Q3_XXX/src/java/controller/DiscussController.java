/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.CommentDBContext;
import dal.ThreadDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;

import model.Thread1;
import model.Comment;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class DiscussController extends HttpServlet{

     private boolean isAuthenticated(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request))
        {
            //do business
            ThreadDBContext db = new ThreadDBContext();
            CommentDBContext db1 = new CommentDBContext();
            ArrayList<Thread1> threads = db.all();
            ArrayList<Comment> comments = db1.all();
            request.setAttribute("threads", threads);
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("discuss.jsp").forward(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request))
        {
            int threadId = Integer.parseInt(request.getParameter("threadid"));
            String comment = request.getParameter("comment");
            Comment c = new Comment();
            Account user = (Account)request.getSession().getAttribute("user");
            c.setAccount(user);
            Thread1 t = new Thread1();
            t.setId(threadId);
            c.setThread(t);
            c.setTitle(comment);
            CommentDBContext db = new CommentDBContext();
            db.insert(c);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    }
}
