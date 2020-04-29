

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firstone" )   //매핑형, 2개이상도 부여가 가능하다. 그럴경우 {"firstone", "firsttwo"}
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("gname");
		out.print("<h1> 안녕하세요! "+s+"회원님 ~_~</h1>");
		System.out.println("표준 출력합니다");
		out.close();
	}

}
