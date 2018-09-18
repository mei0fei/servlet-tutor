package com.example.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@MultipartConfig: �����ϴ��ļ������ԣ���С������
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name="MutliPartServlet", urlPatterns="/upload")
public class MutliPartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/upload.jsp");
		dispatcher.forward(req, resp);

	}

	private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return null;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//   unix, linux /    ms: \
		String uploadPath = getServletContext().getRealPath("")  + "upload";
		System.out.println("uploadPath = " + uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();

        try {
            String fileName = "";
            for (Part part : req.getParts()) {
                fileName = getFileName(part);//��ȡ�ļ�����
                if(fileName==null || fileName.equals("")) continue;
                //System.out.println(fileName);
                part.write(uploadPath + File.separator + fileName);//��partд�뵽�ļ�
            }
            //�����ļ�д��ɹ�
            req.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            req.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(req, resp);
		
	}
}
