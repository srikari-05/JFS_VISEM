package com.skillnext2;

import com.skillnext2.StudentDAO;
import com.skillnext2.Student;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int sem = Integer.parseInt(request.getParameter("sem"));
        String department = request.getParameter("department");

        Student student = new Student(id, sem, department);
        StudentDAO dao = new StudentDAO();

        boolean result = dao.addStudent(student);

        if (result) {
            response.getWriter().println("Student inserted successfully");
        } else {
            response.getWriter().println("Error inserting student");
        }
    }
}
