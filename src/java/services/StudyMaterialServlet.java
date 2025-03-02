/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.StudyMaterialDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author kanoo
 */
@WebServlet(name = "StudyMaterialServlet", urlPatterns = {"/StudyMaterialServlet"})
@MultipartConfig
public class StudyMaterialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("studyMaterial.jsp");
//        System.err.println("Here");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OutputStream os = null;
        InputStream is = null;

        try {
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            // Get parameters
            String subject = request.getParameter("subject");
            String studyText = request.getParameter("studyText");
            String oldFileName = request.getParameter("updatedFileName");
            Long id = Long.parseLong(request.getParameter("id"));

            System.err.println(" 1- " + fileName);
            System.err.println(" 2-  " + oldFileName);

            if (fileName != null && !fileName.equalsIgnoreCase("")) {
                // Define the directory
                File uploadDir = new File("C:/Users/kanoo/OneDrive/Documents/NetBeansProjects/StudyEase/build/web/studymaterials");
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Define file path
                File file = new File(uploadDir, fileName);
                os = new FileOutputStream(file);
                is = filePart.getInputStream();

                // Read & Write file
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

            if (id == -1) {
                id = null;
            } else {
                if ((fileName == null || fileName.equalsIgnoreCase("")) && (oldFileName != null && !oldFileName.equalsIgnoreCase(""))) {
                    fileName = oldFileName;
                }
            }

            // save
            StudyMaterialDao smd = new StudyMaterialDao();
            smd.saveStudyMaterial(subject, fileName, studyText, id);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Close streams properly
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ignored) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignored) {
                }
            }

        }
        response.sendRedirect("studyMaterial.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
