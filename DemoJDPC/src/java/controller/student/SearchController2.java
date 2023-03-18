package controller.student;

import dal.DBContext;
import dal.DepartmentDBContext;
import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Department;
import model.Student;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class SearchController2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.all();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/student/search.jsp").forward(request, response);
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
         String deptid = request.getParameter("deptid");
         StudentDBContext db = new StudentDBContext();
         ArrayList<Student> students = db.search(deptid);
         request.setAttribute("students", students);
         request.getRequestDispatcher("../view/student/list.jsp").forward(request, response);
    }
}
