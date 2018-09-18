package com.example.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 列出需要下载的文件
 * */

@WebServlet(name="ListDownloadFileServlet", urlPatterns="/list-download")
public class ListDownloadFileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String downloadPath = getServletContext().getRealPath("/");
		downloadPath = downloadPath + "WEB-INF" +  File.separator + "download" + File.separator; 
		System.out.println(downloadPath);		
		File file = new File(downloadPath);
		File[] files;
		if(file.isDirectory()){
			files = file.listFiles();
			req.setAttribute("files", files);
			//files[1].getName();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/list-download.jsp");
		dispatcher.forward(req, resp);

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
