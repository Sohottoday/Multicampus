package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		if(keyword == null) {
			List<MeetingVO> list = dao.listAll();
			for(MeetingVO vo : list) {
				System.out.println(vo.getTitle());
			}
			request.setAttribute("list", list);
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if(list.size() ==0) {
				request.setAttribute("msg", keyword+"를 담고있는 글이 없슴돠");
				request.setAttribute("list",  list);
			} else {
				request.setAttribute("list",  list);
			}
		}
		
		String id = request.getParameter("id");
		if(id!=null) {
			dao.delete(Integer.parseInt(id));
			List<MeetingVO> list = dao.listAll();
			request.setAttribute("list", list);
		} 
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String mdate = request.getParameter("meetingDate");
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(mdate);
		boolean result = dao.insert(vo);
				
		if(result) {
			request.setAttribute("msg", name+"님의 글이 저장되었습니다.");
		} else {
			request.setAttribute("msg", name+"님의 글의 저장이 실패하였습니다.");
		}
		
		List<MeetingVO> list = dao.listAll();
		request.setAttribute("list",  list);
		
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	
	}

}
