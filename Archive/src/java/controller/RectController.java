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
import model.MyRect;

/**
 *
 * @author ngotungson
 */
public class RectController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        ArrayList<MyRect> rects = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int w = random.nextInt(51)+50;
            int h = random.nextInt(51)+50;
            int x = random.nextInt(501-w);
            int y = random.nextInt(501-h);
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            MyRect r = new MyRect();
            r.setX(x);
            r.setY(y);
            r.setW(w);
            r.setH(h);
            r.setRed(red);
            r.setGreen(green);
            r.setBlue(blue);
            rects.add(r);
        }
        req.setAttribute("rects", rects);
        req.getRequestDispatcher("view/rect.jsp").forward(req, resp);
        
    }
    
}
