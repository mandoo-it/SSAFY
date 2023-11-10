package chapter02;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamTest1
 */
@WebServlet({ "/param1.do" })
public class ParamTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String text = request.getParameter("text");
		String password = request.getParameter("password");
		String[] habby = request.getParameterValues("habby");
		String content = request.getParameter("content");
		
		System.out.println(text  +password + habby + content);
		System.out.println(Arrays.toString(habby));
		
	}


}
