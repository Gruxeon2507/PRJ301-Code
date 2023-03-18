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
import java.util.ArrayList;
import java.util.Random;
import model.Circle;
/**
 *
 * @author Nguyen Hoang Minh
 */
public class CircleController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        ArrayList<Circle>  circles = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<num;i++){
            Circle c = new Circle();
            c.setRadius(random.nextInt(31)+20);
            c.setX(random.nextInt(500-2*c.getRadius())+c.getRadius());
            c.setY(random.nextInt(500-2*c.getRadius())+c.getRadius());
            c.setRed(random.nextInt(256));
            c.setBlue(random.nextInt(256));
            c.setGreen(random.nextInt(256));
            circles.add(c);
        }
        req.setAttribute("circles", circles);
        req.getRequestDispatcher("view/circle.jsp").forward(req, resp);
    }
    
}
