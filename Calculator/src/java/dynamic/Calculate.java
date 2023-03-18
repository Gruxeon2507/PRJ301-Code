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
@WebServlet(urlPatterns = "/calculate")
public class Calculate extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double first= Double.parseDouble(req.getParameter("firstnum"));
        double second=Double.parseDouble(req.getParameter("secondnum"));
        String operator = req.getParameter("operator");
        if(operator.equals("plus")){
            resp.getWriter().println(first+second);
        }
        if(operator.equals("minus")){
            resp.getWriter().println(first-second);
        }
        if(operator.equals("multiply")){
            resp.getWriter().println(first*second);
        }
        if(operator.equals("divide")){
            if(second==0){
                resp.getWriter().println("ERROR: DIVIDED BY ZERO");
            }
            else{
                 resp.getWriter().println(first/second);
            }    
        }
    }
    
}
