package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = {"/*"}, description="login check filter")
public class CheckLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("----------do login check---------------");
		
		//����¼��־���ж��û��Ƿ��¼
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		//System.out.println(request.getRequestURI());
		
		if(! ( (request.getRequestURI().endsWith("login") ||
				request.getRequestURI().endsWith("logout") 
				) ))
		{
			System.out.println(request.getRequestURI());
			
			Object o = request.getSession().getAttribute("logined");
			if(!"yes".equals(o)){//���û�е�¼������������ת����¼ҳ��
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(req, resp);
				return;
			}
			
		}
		
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
