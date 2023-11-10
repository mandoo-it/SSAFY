package com.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FoodDAO;
import com.dao.IFoodDAO;
import com.dao.IMemberDAO;
import com.dao.MemberDAO;
import com.vo.Food;
import com.vo.Member;

@WebServlet("/safefoodController")
public class safefoodController extends HttpServlet {

	IFoodDAO dao;
	IMemberDAO mdao;

	public safefoodController() {
		dao = new FoodDAO();
		mdao = new MemberDAO();
	}

	public void main(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<Food> list = null;
        HttpSession session = req.getSession(false);
        if(session !=null)
        if (session.getAttribute("login") != null) {
                list = (ArrayList<Food>)session.getAttribute("item");
        }
        req.setAttribute("list", list);
        RequestDispatcher dis = req.getRequestDispatcher("/view/index.jsp");
        try {
            dis.forward(req, res);
        } catch (Exception e) {
        }
    }
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Food> list = dao.selectAll();
		req.setAttribute("list", list);
		// view로 넘어감
	    req.setAttribute("sort","상품 번호");
		req.setAttribute("sort2", "내림차순");
		RequestDispatcher dis = req.getRequestDispatcher("/view/productInfoList.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
        Food f = dao.selectOne(req.getParameter("id"));
        req.setAttribute("f", f);
        // view로 넘어감
        HttpSession session = req.getSession(false);
        if(session !=null)
        if (session.getAttribute("login") != null) {
            if (session.getAttribute("item") == null) {
                ArrayList<Food> fl = new ArrayList<>();
                fl.add(f);
                session.setAttribute("item", fl);
            } else {
                ArrayList<Food> fl = (ArrayList<Food>)session.getAttribute("item");
                if(fl.size()>=6)fl.remove(0);
                fl.add(f);
                session.setAttribute("item", fl);
            }
        }
        
        RequestDispatcher dis = req.getRequestDispatcher("/view/detail.jsp");
        try {
            dis.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void insert(HttpServletRequest req, HttpServletResponse res) {

	}

	public void insertProcess(HttpServletRequest req, HttpServletResponse res) {

	}

	public void delete(HttpServletRequest req, HttpServletResponse res) {

	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/view/login.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {

		// id pass 확인
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		Member m;
		try {
			m = mdao.search(id);
			HttpSession session = req.getSession();
			System.out.println(m);
			if (m != null) {
				if (m.getPassword().equals(password)) {
					session.setAttribute("login", id);
					res.sendRedirect("main.food");
				} else {
					// alert 비밀번호가잘못댐
					res.sendRedirect("login.food");
				}
			} else {
				// alert 아이디가잘못댐
				res.sendRedirect("login.food");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void signin(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/view/signin.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void signinProcess(HttpServletRequest req, HttpServletResponse res) {
		String aa = req.getParameter("id");
		String bb = req.getParameter("password");
		String cc = req.getParameter("username");
		String dd = req.getParameter("email");
		String ee = req.getParameter("address");
		String ff = req.getParameter("phone");
		String[] ga = req.getParameterValues("allergy");
		String gg = "";
		if(ga != null) {
			for (int i = 0; i < ga.length; i++) {
				gg += ga[i] + ",";
			}
		}
	
		System.out.println(aa + " " + bb + " " + cc + " " + dd + " " + ee + " " + ff + " " + gg);
		try {
			RequestDispatcher dis = req.getRequestDispatcher("/view/index.jsp");
			mdao.add(new Member(aa, bb, cc, dd, ee, ff, gg));
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.setAttribute("login", null);
		try {
			res.sendRedirect("main.food");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(HttpServletRequest req, HttpServletResponse res) {

		ArrayList<Food> list = dao.search(req.getParameter("key"),req.getParameter("sort"),req.getParameter("sort2"), req.getParameter("word"));
		System.out.println(req.getParameter("sort"));
		req.setAttribute("list", list);
		req.setAttribute("word", req.getParameter("word"));

		if(req.getParameter("sort").equals("calory")) {
			req.setAttribute("sort", "칼로리");
		} else  if(req.getParameter("sort").equals("natrium")) {
			req.setAttribute("sort", "나트륨");
		} else  if(req.getParameter("sort").equals("code")) {
			req.setAttribute("sort", "상품번호");
		}
			
		if(req.getParameter("sort2").equals("asc")) {
			req.setAttribute("sort2", "오름차순");
		} else req.setAttribute("sort2", "내림차순");
		
		// view로 넘어감

		RequestDispatcher dis = req.getRequestDispatcher("/view/productInfoList.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void memberModify(HttpServletRequest req, HttpServletResponse res) {
		// id
		HttpSession session = req.getSession();
		try {
			Member m = mdao.search((String) session.getAttribute("login"));
			req.setAttribute("m", m);
			RequestDispatcher dis = req.getRequestDispatcher("/view/membermodify.jsp");
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void membermodifyPs(HttpServletRequest req, HttpServletResponse res) {
		String aa = req.getParameter("id");
		String bb = req.getParameter("password");
		String cc = req.getParameter("username");
		String dd = req.getParameter("email");
		String ee = req.getParameter("address");
		String ff = req.getParameter("phone");
		String[] ga = req.getParameterValues("allergy");
		String gg = "";
		for (int i = 0; i < ga.length; i++) {
			gg += ga[i] + ",";
		}

		System.out.println(aa + " " + bb + " " + cc + " " + dd + " " + ee + " " + ff + " " + gg);
		try {
			RequestDispatcher dis = req.getRequestDispatcher("/view/index.jsp");
			mdao.update(new Member(aa, bb, cc, dd, ee, ff, gg));
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void memberDelete(HttpServletRequest req, HttpServletResponse res) {
		// id
		HttpSession session = req.getSession();
		try {
			mdao.remove((String) session.getAttribute("login"));
			session.setAttribute("login", null);
			res.sendRedirect("main.food");
		} catch (Exception e) {
		}
	}

	public void searchMain(HttpServletRequest req, HttpServletResponse res) {
		  	ArrayList<Food> list = dao.searchMain(req.getParameter("key"), req.getParameter("word"));
	        if(req.getParameter("word") != null)
	        	req.setAttribute("list", list);
	        // view로 넘어감
	        req.setAttribute("word", req.getParameter("word"));
	        req.setAttribute("sort","상품 번호");
			req.setAttribute("sort2", "내림차순");
	        RequestDispatcher dis = req.getRequestDispatcher("/view/productInfoList.jsp");
	        try {
	            dis.forward(req, res);
	        } catch (Exception e) {
	        }
		
	}

}
