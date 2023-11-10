package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter(filterName = "/MyFilter",urlPatterns = {"/HelloServlet", "/ByeServlet"})
public class MyFilter implements Filter {
	
	public void destroy() {
		
	}

	//doFilter() : 필터가 수행하는 내용을 가지고있는 메소드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사전 처리 작업 내용
		System.out.println("Myfilter..before");
		chain.doFilter(request, response);//다음 필터나 서블릿으로 request, response객체 전달
		// 사후 처리 작업 내용
		System.out.println("Myfilter..after");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
