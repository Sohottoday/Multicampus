package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter visitorwrite = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		LocalDate timenow = LocalDate.now();
		////ocalDate timetext = LocalDate.of(timenow.getYear(), timenow.getMonthValue(), timenow.getDayOfMonth());
		//visitorwrite.print("<h2>"+request.getParameter("vname")+"님이 "+timetext+"에 남긴 글입니다.</h2><hr><h3>내용 : "+request.getParameter("textmemo"));
		visitorwrite.print("<h2>"+request.getParameter("vname")+"님이 "+timenow.getYear()+"년"+timenow.getMonthValue()+"월"+timenow.getDayOfMonth()+"일에 남긴 글입니다.</h2><hr><h3>내용 : "+request.getParameter("textmemo"));
		visitorwrite.print("<br><br><a href='http://70.12.115.178:8000/sedu/html/visitorForm.html'>입력화면으로</a>");
		
		visitorwrite.close();
	}

}
