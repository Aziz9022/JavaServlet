package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TableCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Retrieve cookies
        Cookie[] cookies = req.getCookies();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Active Cookies</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th><th>Value</th></tr>");

        // Check if there are cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
//                if ("JSESSIONID".equalsIgnoreCase(cookie.getName())) {
//                    continue;
//                }
                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("</tr>");
            }
        }
        //else {
        //   out.println("<tr><td colspan='2'>No cookies found</td></tr>");
        // }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
