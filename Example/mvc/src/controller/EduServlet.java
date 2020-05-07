package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/eduservlet")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int stavg = Integer.parseInt(request.getParameter("avgnum"));
		
		if(stavg>=90) {
			RequestDispatcher gradeA = request.getRequestDispatcher("/jspexam/gradeA2.jsp");
			gradeA.forward(request, response);
		} else if(stavg >=80 && stavg <90) {
			RequestDispatcher gradeB = request.getRequestDispatcher("/jspexam/gradeB.jsp");
			gradeB.forward(request, response);
		} else if(stavg >=70 && stavg <80) {
			RequestDispatcher gradeC = request.getRequestDispatcher("/jspexam/gradeC.jsp");
			gradeC.forward(request, response);
		} else {
			RequestDispatcher gradeD = request.getRequestDispatcher("/jspexam/gradeD.jsp");
			gradeD.forward(request, response);
		}
	}

}
