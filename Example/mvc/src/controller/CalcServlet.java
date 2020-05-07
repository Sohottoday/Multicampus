package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int firstNum = Integer.parseInt(request.getParameter("firstnum"));
		int secondNum = Integer.parseInt(request.getParameter("secondnum"));
		String cal = request.getParameter("cal");
		
		if(cal.equals("/") && secondNum==0) {
			String result = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다.";
			request.setAttribute("number", result);
			request.getRequestDispatcher("/jspexam/errorResult.jsp").forward(request, response);
		} else {
			int result=0;
			switch(cal) {
			case "+" : result = firstNum+secondNum;
			break;
			case "-" : result = firstNum=secondNum;
			break;
			case "*" : result = firstNum*secondNum;
			break;
			case "/" : result = firstNum/secondNum;
			break;
			}
			request.setAttribute("number", result);
			request.getRequestDispatcher("/jspexam/calcResult.jsp").forward(request, response);
		}
	}
}
