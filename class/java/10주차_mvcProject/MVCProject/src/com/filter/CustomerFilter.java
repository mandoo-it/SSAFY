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

import com.controller.CustomerController;

//클라이언트로부터 돌아오는 모든 요청이 들어오는 front controller 그냥 url 걸러내서 컨트롤러에 전달하는 역할만 함 
//@WebFilter("/CustomerFilter")
public class CustomerFilter implements Filter {

	public void destroy() {}

	//http://localhost:8080/context-root/list.cus 초기화면 경로 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response; //타입형변환 
		
		req.setCharacterEncoding("utf-8"); //클라이언트로 들어오는 한글 안깨지게 처리 
		CustomerController cc = new CustomerController(); 
		//클라이언트로부터 들어오는 요청을 구분해서 Controller에게 작업지시
		String reqString = req.getServletPath(); //url 값에서 맨 끝부분의 문자를 알아냄 : /list.cus, read.cus...... 
		System.out.println(reqString);
		
		if(reqString.equals("/list.cus")) {//초기화면 
			cc.list(req, res); //
		}else if(reqString.equals("/read.cus")) {
			cc.read(req, res);
		} else if(reqString.equals("/read.cus")) {
			cc.read(req, res);
		} else if(reqString.equals("/insert.cus")) {
			cc.insert(req, res);
		}else if(reqString.equals("/insertProcess.cus")) {
			cc.insertProcess(req,res);
		} else if(reqString.equals("/delete.cus")) {
			cc.delete(req,res);
		} else if(reqString.equals("/login.cus")) { //로그인화면
			cc.login(req,res);
		} else if(reqString.equals("/loginProcess.cus")) {//로그인처리
			cc.loginProcess(req,res);
		} else if(reqString.equals("/logout.cus")) {//로그아웃
			cc.logout(req,res);
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
