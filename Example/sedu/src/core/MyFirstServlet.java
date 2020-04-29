package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8" );
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		LocalDate getDate = LocalDate.now();
		String result;
		switch(getDate.getDayOfWeek().getValue()) {
		case 1 : result="월";
			break;
		case 2 : result="화";
			break;
		case 3 : result="수";
			break;
		case 4 : result="목";
			break;
		case 5 : result="금";
			break;
		case 6 : result="토";
			break;
		default : result="일";
			break;
		}
		
		
		 if(name==null) { name = "GUEST"; }
		 
		out.print("<h2>"+name+"님 반가워요.. 오늘은 "+result+"요일입니다!!</h2>");
		out.close();
	}

}
