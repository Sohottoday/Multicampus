package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter pwriter = response.getWriter();
		String name = request.getParameter("action");
		
		if(name==null) {
			pwriter.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>");
			pwriter.print("<h3>응답 : http://localhost:8000/edu/move?action=naver</h3>");
			pwriter.print("<h3>응답 : http://localhost:8000/edu/move?action=daum</h3>");
			pwriter.print("<h3>응답 : http://localhost:8000/edu/move?action=google</h3>");
			pwriter.print("<h3>응답 : http://localhost:8000/edu/move</h3>");
		} else {
			if(name.equals("naver")) {
				response.sendRedirect("http://www.naver.com/");
			} else if(name.equals("daum")) {
				response.sendRedirect("http://www.daum.co.kr/");
			} else if(name.equals("google")){
				response.sendRedirect("http://www.google.com/");
			}		
		}
		pwriter.close();
		
	}

}
