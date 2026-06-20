package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        StudentBean sb = new StudentBean();
        sb.setSid(req.getParameter("sid"));
        sb.setSname(req.getParameter("sname"));
        sb.setEmail(req.getParameter("email"));
        sb.setPhno(Long.parseLong(req.getParameter("phone")));
        sb.setCourse(req.getParameter("course"));
        sb.setAddr(req.getParameter("addr"));

        try {
            int k = new StudentDAO().updateStudent(sb);
            if(k > 0) {
                pw.println("Student Updated Successfully!<br>");
                RequestDispatcher rd = req.getRequestDispatcher("viewStudents");
                rd.include(req, res);
            }
        } catch(Exception e) {
            pw.println("Error: " + e.getMessage());
        }
    }
}