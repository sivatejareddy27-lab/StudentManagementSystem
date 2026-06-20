package p1;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/viewStudents")
public class ViewStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        try {
            List<StudentBean> list = new StudentDAO().viewStudents();
            pw.println("<h2>Students List</h2>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Course</th><th>Address</th><th>Action</th></tr>");
            for(StudentBean sb : list) {
                pw.println("<tr>");
                pw.println("<td>"+sb.getSid()+"</td>");
                pw.println("<td>"+sb.getSname()+"</td>");
                pw.println("<td>"+sb.getEmail()+"</td>");
                pw.println("<td>"+sb.getPhno()+"</td>");
                pw.println("<td>"+sb.getCourse()+"</td>");
                pw.println("<td>"+sb.getAddr()+"</td>");
                pw.println("<td><a href='deleteStudent?sid="+sb.getSid()+"'>Delete</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("<br><a href='home.html'>Back</a>");
        } catch(Exception e) {
            pw.println("Error: " + e.getMessage());
        }
    }
}