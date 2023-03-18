/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.MyRect;

/**
 *
 * @author ngotungson
 */
public class RectView extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<MyRect> rects = (ArrayList<MyRect>)request.getAttribute("rects");
        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");

        resp.getWriter().println("<canvas id=\"myCanvas\" width=\"500\" height=\"500\" style=\"border:1px solid #d3d3d3;\">");
        resp.getWriter().println("Your browser does not support the HTML5 canvas tag.</canvas>");

        resp.getWriter().println("<script>");
        resp.getWriter().println("var c = document.getElementById(\"myCanvas\");");
        resp.getWriter().println("var ctx = c.getContext(\"2d\");");
        for (MyRect rect : rects) {
            resp.getWriter().println("ctx.fillStyle = \"rgb("+rect.getRed()+","+rect.getGreen()+","+rect.getBlue()+")\";");
            resp.getWriter().println("ctx.fillRect("+rect.getX()+", "+rect.getY()+", "+rect.getW()+", "+rect.getH()+");");
        }

        
        resp.getWriter().println("</script>");

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

        
    }
    
}
