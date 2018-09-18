package com.example.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="DownloadServlet", urlPatterns="/download")
public class DownloadServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
    	//resp.setContentType("text/plain");
    	String filename = req.getParameter("filename");
    	System.out.println(filename);

        resp.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("utf-8"), "ISO_8859_1") );

        try(
        	InputStream	in = req.getServletContext().getResourceAsStream("/WEB-INF/download/"+filename); 
        	OutputStream out = resp.getOutputStream()
        ){
        	
            byte[] buffer = new byte[ARBITARY_SIZE];
            
            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
