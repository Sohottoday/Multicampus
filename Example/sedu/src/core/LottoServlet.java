package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lotto1")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		String sendnum = request.getParameter("sendnum");
		int picknum = Integer.parseInt(sendnum);
		int rannum = (int)(Math.random()*6)+1;
		System.out.println("입력한 숫자 : "+picknum + "\n"+ "랜덤 숫자 : "+rannum);
		
		if(picknum==rannum) {
			RequestDispatcher succes =  request.getRequestDispatcher("/jspexam/succes.jsp");
			succes.forward(request, response);
		} else {
			RequestDispatcher fail =  request.getRequestDispatcher("/jspexam/fail.jsp");
			fail.forward(request, response);
		}
		
	}

}
