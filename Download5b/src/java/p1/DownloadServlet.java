/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author kanoo
 */



public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("APPLICATION/OCTET-STREAM");
        try (PrintWriter out = response.getWriter()) {
            String filename = request.getParameter("filename");
            ServletContext context = getServletContext();
            try (InputStream is = context.getResourceAsStream("/" + filename)) {
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                int i;
                while ((i = is.read()) != -1) {
                    out.write(i);
                }
            }
        }
    }

}
