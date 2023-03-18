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
import model.Student;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class StudentController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        ArrayList<Student> students = new ArrayList<>();
        Random random = new Random();
        for(int i=1;i<=num;i++){
            Student student = new Student();
            student.setId(i+"");
            int gender = random.nextInt(2);
            if(gender==0){
                student.setName("Ms "+i);
                student.setGender(false);
            }else{
                student.setName("Mr "+i);
                student.setGender(true);
            }
            students.add(student);
        }
        req.setAttribute("students", students);
        req.getRequestDispatcher("view/studentManager.jsp").forward(req, resp);
    }
    
    
}