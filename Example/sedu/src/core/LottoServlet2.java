package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendnum = request.getParameter("sendnum");
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int [1]);
		}
		int [] session_v = (int[])session.getAttribute("cnt");
		session_v[0]+=1;
		int picknum = Integer.parseInt(sendnum);
		int rannum = (int)(Math.random()*6)+1;
		System.out.println("입력한 숫자 : "+picknum + "\n"+ "랜덤 숫자 : "+rannum);
		
		if(session_v[0]>=4) {
			RequestDispatcher impossible = request.getRequestDispatcher("/jspexam/impossible.jsp");
			impossible.forward(request, response);
		} else {	
			if(picknum==rannum) {
				RequestDispatcher succes =  request.getRequestDispatcher("/jspexam/succes.jsp");
				succes.forward(request, response);
				session_v[0]=10;
			} else {
				RequestDispatcher fail =  request.getRequestDispatcher("/jspexam/fail.jsp");
				fail.forward(request, response);
			}
		}		
	}
}
