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
import model.Rectangle;
import java.util.Random;
/**
 *
 * @author Nguyen Hoang Minh
 */
public class RectController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Rectangle> list = new ArrayList<>();
        Random rand = new Random();
        int n = Integer.parseInt(req.getParameter("amount"));
        for(int i=0;i<n;i++){
            Rectangle rectangle = new Rectangle();
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            int height=rand.nextInt(500-x);
            int width=rand.nextInt(500-y);
            rectangle.setX(x);
            rectangle.setY(y);
            rectangle.setHeight(height);
            rectangle.setWidth(width);
            list.add(rectangle);
        }
        req.setAttribute("rectangle", list);
        req.getRequestDispatcher("/view/rect").forward(req, resp);
    }
    
}
