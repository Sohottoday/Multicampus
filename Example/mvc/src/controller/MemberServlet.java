package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;


@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mname=request.getParameter("name");
		String mphone=request.getParameter("phone");
		String mid=request.getParameter("id");
		String mpass=request.getParameter("pass");
		MemberVO vo= new MemberVO();
		
		
		if(mname.equals("")) {
			mname="없음";
		}
		if(mphone.equals("")) {
			mphone="없음";
		}
		if(mid.equals("")) {
			mid="없음";
		}
		if(mpass.equals("")) {
			mpass="없음";
		}

		vo.setName(mname);
		vo.setPhone(mphone);
		vo.setId(mid);
		vo.setPass(mpass);
		request.setAttribute("info", vo);
		
		request.getRequestDispatcher("/jspexam/memberView_2.jsp").
        forward(request, response);
		
		
	}

}
