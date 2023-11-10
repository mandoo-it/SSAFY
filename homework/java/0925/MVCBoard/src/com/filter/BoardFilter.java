package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardController;



@WebFilter(filterName="/BoardFilter", urlPatterns= {"*.bod"})
public class BoardFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		req.setCharacterEncoding("utf-8"); // 클라이언트로부터 들어오는 한글 안깨지게 처리
		BoardController cc = new BoardController();
		// 클라이언트로부터 들어오는 요청을 구분해서 Controller에게 작업 지시
		// url 값에서 맨끝부분의 문자를 알아냄
		String reqString = req.getServletPath();
		// System.out.println(reqString);
		if (reqString.equals("/list.bod")) {
			cc.list(req, res);
		} else if (reqString.equals("/read.bod")) {
			cc.read(req, res);
		} else if (reqString.equals("/insert.bod")) {
			cc.insert(req, res);
		} else if (reqString.equals("/insertProcess.bod")) {
			cc.insertProcess(req, res);
		} else if (reqString.equals("/delete.bod")) {
			cc.delete(req, res);
		} else if (reqString.equals("/mouse.bod")) {
			cc.mouse(req, res);
		}
		else if (reqString.equals("/login.bod")) {
			cc.login(req, res);
		} else if (reqString.equals("/loginProcess.bod")) {
			cc.loginProcess(req, res);
		} else if (reqString.equals("/logout.bod")) {
			cc.logout(req, res);
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
