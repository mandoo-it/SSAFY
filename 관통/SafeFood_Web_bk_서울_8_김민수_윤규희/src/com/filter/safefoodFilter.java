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

import com.controller.safefoodController;

@WebFilter(filterName = "/safefoodFilter", urlPatterns = { "*.food" })
public class safefoodFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		safefoodController cc = new safefoodController();
		String reqString = req.getServletPath();
		if (reqString.equals("/list.food")) {
			cc.list(req, res);
		} else if (reqString.equals("/read.food")) {
			cc.read(req, res);
		} else if (reqString.equals("/insert.food")) {
			cc.insert(req, res);
		} else if (reqString.equals("/insertProcess.food")) {
			cc.insertProcess(req, res);
		} else if (reqString.equals("/delete.food")) {
			cc.delete(req, res);
		} else if (reqString.equals("/login.food")) {
			cc.login(req, res);
		} else if (reqString.equals("/signin.food")) {
			cc.signin(req, res);
		} else if (reqString.equals("/loginProcess.food")) {
			cc.loginProcess(req, res);
		} else if (reqString.equals("/logout.food")) {
			cc.logout(req, res);
		} else if (reqString.equals("/main.food")) {
			cc.main(req, res);
		} else if (reqString.equals("/search.food")) {
			cc.search(req, res);
		} else if (reqString.equals("/signinProcess.food")){
			cc.signinProcess(req, res);
		}else if (reqString.equals("/membermodify.food")){
			cc.memberModify(req, res);
		}else if (reqString.equals("/membermodifyPs.food")){
			cc.membermodifyPs(req, res);
		}else if (reqString.equals("/memberdelete.food")){
			cc.memberDelete(req, res);
		}else if (reqString.equals("/search_main.food")){
			cc.searchMain(req, res);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
