package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.controller.BookController;

public class BookFilter implements Filter {
 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response; //타입형변환 
		
		req.setCharacterEncoding("utf-8"); //클라이언트로 들어오는 한글 안깨지게 처리 
		BookController cc = new BookController(); 
		//클라이언트로부터 들어오는 요청을 구분해서 Controller에게 작업지시
		String reqString = req.getServletPath(); //url 값에서 맨 끝부분의 문자를 알아냄 : /list.cus, read.cus...... 
		System.out.println(reqString);
		
		if(reqString.equals("/list.cus")) {//초기화면 
			cc.list(req, res); //
		}else if(reqString.equals("/read.cus")) {
			cc.read(req, res);
		} 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
