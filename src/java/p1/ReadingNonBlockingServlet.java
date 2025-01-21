/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
 *
 * @author kanoo
 */
@WebServlet(name="ReadingNonBlockingServlet", urlPatterns={"/ReadingNonBlockingServlet"}, asyncSupported=true)

public class ReadingNonBlockingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        AsyncContext ac = request.startAsync();
        ServletInputStream sis = request.getInputStream();
        sis.setReadListener(new ReadingListener(sis,ac));
    }
}

