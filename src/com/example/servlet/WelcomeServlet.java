package com.example.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="WelcomeServlet", urlPatterns="/welcome")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		dispatcher.forward(req, resp);
		/*
		//����¼��־���ж��û��Ƿ��¼
		Object o = req.getSession().getAttribute("logined");
		if("yes".equals(o)){
			
		}else{
			resp.sendRedirect("login");//��ת����¼ҳ��
		}*/
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
