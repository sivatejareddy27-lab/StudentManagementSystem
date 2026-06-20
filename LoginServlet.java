package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        if(uname.equals("admin") && pwd.equals("admin123")) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", uname);
            res.sendRedirect("home.html");
        } else {
            pw.println("Invalid credentials!<br>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        }
    }
}