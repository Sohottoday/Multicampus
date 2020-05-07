package core;

import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter rememo = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String [] rplus = request.getParameterValues("plus");
		rememo.print("<h1>"+request.getParameter("rname")+"님의 예약내용</h1><hr>");
		rememo.print("<ul><li>룸 : "+request.getParameter("rroom")+"</li><li>추가 요청 사항 : ");
		if(rplus==null) { 
			rememo.print("없음");
		} else {
			for(String plus: rplus) {
				rememo.print(plus+" ");
			}
		}
		String aaa = request.getParameter("rdate");
		LocalDate ddate = LocalDate.parse(aaa);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
				
		rememo.print("</li><li>예약 날짜 : "+ddate.format(dtf)+"</li></ul>");
		
		rememo.print("<br><br><a href='http://70.12.115.178:8000/sedu/html/reservation.html'>예약입력화면으로</a>");
	}

}
