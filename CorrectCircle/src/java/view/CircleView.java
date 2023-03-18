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
import model.Circle;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class CircleView extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Circle> circles = (ArrayList<Circle>) req.getAttribute("circles");
        resp.getWriter().println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n"
                + "\n"
                + "<canvas id=\"myCanvas\" width=\"500\" height=\"500\" style=\"border:1px solid #d3d3d3;\">\n"
                + "Your browser does not support the HTML5 canvas tag.</canvas>\n"
                + "\n"
                + "<script>\n"
                + "var c = document.getElementById(\"myCanvas\");\n"
                + "var ctx = c.getContext(\"2d\");\n"
        );
        for(int i=0;i<circles.size();i++){
       resp.getWriter().println("ctx.beginPath();\n"
                + "ctx.arc("+circles.get(i).getX()+"," +circles.get(i).getY()+","+circles.get(i).getRadius()+",0, 2 * Math.PI);\n"
                + "ctx.fillStyle = \"rgb("+circles.get(i).getRed()+","+circles.get(i).getBlue()+","+circles.get(i).getGreen()+")\";"
                + "ctx.fill();"
                + "ctx.stroke();\n");
                }
        resp.getWriter().println(
                "</script> \n"
                + "\n"
                + "</body>\n"
                + "</html>");
    }

}
