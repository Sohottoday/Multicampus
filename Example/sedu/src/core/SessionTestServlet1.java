package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessiontest1")
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); //만들어져 있으면 가져오고 안만들어져 있다면 그때 세션을 만든다. 한번만 등록.
		if(session.getAttribute("cnt")==null)
			session.setAttribute("cnt", new int [1]); //데이터를 저장할 방을 등록, 방은 타입이 어떻든 무조건 객체여야 한다.
		int [] session_v = (int[])session.getAttribute("cnt");
		session_v[0] += 10;
		
		member_v +=10;
		local_v +=10;
		
		out.print("<ul>");
		out.print("<li> 멤버 변수 : "+member_v+"</li>");	//각 멤버끼리 공유 할당하며 유지됨
		out.print("<li> 지역 변수 : "+local_v+"</li>");  //요청시마다 메모리 각각 할당 단 유지되진 않음
		out.print("<li> 세션 객체에 저장된 배열 원소값 : "+session_v[0]+"</li>");
		out.print("</ul>");
		out.close();
		
	}

}
