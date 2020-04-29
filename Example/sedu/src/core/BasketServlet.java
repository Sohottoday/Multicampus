package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter computer = response.getWriter();
		String pid = request.getParameter("pid");
		
		computer.print("<h3>선택한 상품 : "+pid+"</h3>");
		computer.print("<img src='/edu/images/"+pid+".jpg' width='300px' height='300px'>");
		computer.print("<br><br><a href='http://70.12.115.178:8000/sedu/html/productlog.html'>상품 선택화면으로 가기</a>");
		//computer.print("<img src=/edu/images/"+);
		computer.close();
		
		
		
	}

}
