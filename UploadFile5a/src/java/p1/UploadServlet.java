/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig//annotation used for file handling

/**
 *
 * @author kanoo
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String path = request.getParameter("destination");
        Part filePart = request.getPart("file");//method used to get all details of file (such as type, name, location, etc)
        String filename = filePart.getSubmittedFileName();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>File Uploaded</title>");
        out.println("</head>");
        out.println("<body bgcolor=lightgreen>");
        out.println("<h2>Filename: " + filename);
        out.println("</h2>");
        out.println("</body>");
        out.println("</html>");
        try {
            OutputStream os = new FileOutputStream(new File(path + File.separator + filename));
            InputStream is = filePart.getInputStream();
            int read;
            while ((read = is.read()) != -1) {
                os.write(read);
            }
            out.println("File Uploaded Successfully!!!!");
        } catch (FileNotFoundException e) {
            out.println(e);
        }
    }

}


