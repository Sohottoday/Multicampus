package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("basket")==null) {
			session.setAttribute("basket", new ProductVO());
		}
		ProductVO vo = (ProductVO)session.getAttribute("basket");
		
		String pid = request.getParameter("pid");
		if(pid.equals("del")) {
			session.invalidate();
			RequestDispatcher selectItem =request.getRequestDispatcher("/jspexam/clear.jsp");
			selectItem.forward(request, response);
			
		} else {
			if(pid.equals("hanwoo1")) {
				vo.setHanwoo1(1);
			} else if(pid.equals("hanwoo2")) {
				vo.setHanwoo2(1);
			} else if(pid.equals("hanwoo3")){
				vo.setHanwoo3(1);
			}	
			RequestDispatcher selectItem =request.getRequestDispatcher("/jspexam/productView.jsp");
			selectItem.forward(request, response);
		}
		
		
		
	}

}
