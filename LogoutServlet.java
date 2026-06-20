package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        
        HttpSession session = req.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        res.sendRedirect("Login.html");
    }
}