package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String sid = req.getParameter("sid");

        try {
            int k = new StudentDAO().deleteStudent(sid);
            if(k > 0) {
                pw.println("Student Deleted Successfully!<br>");
                RequestDispatcher rd = req.getRequestDispatcher("viewStudents");
                rd.include(req, res);
            }
        } catch(Exception e) {
            pw.println("Error: " + e.getMessage());
        }
    }
}