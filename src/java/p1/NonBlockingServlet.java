/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;



/**
 *
 * @author kanoo
 */
public class NonBlockingServlet extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>NonBlockingIO Servlet</title>");
            out.println("</head>");
            out.println("<body bgcolor=lightgreen>");
            out.println("<h1>File Reader</h1>");
            out.println("</body>");
            out.println("</html");
            String filename = "/WEB-INF/CodeExplain.txt";
            ServletContext sc = getServletContext();
            InputStream is = sc.getResourceAsStream(filename);
            String path = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ReadingNonBlockingServlet";
            URL url = new URL(path);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setChunkedStreamingMode(2);
            con.setDoOutput(true);
            con.connect();
            if(is != null)
            {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String text = "";
                System.out.println("Reading Started...");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
                while((text = br.readLine()) != null)
                {
                    out.print(text+"<br>");
                    try
                    {
                        Thread.sleep(500);
                        out.flush();
                    }
                    catch(InterruptedException ex){}
                }
                out.print("Reading Completed...");
                bw.flush();
                bw.close();
            }
        }
    }
    
}
