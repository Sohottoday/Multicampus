package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); 
		String writer=request.getParameter("writer");
		NewsDAO dao = new NewsDAO();
		String action = request.getParameter("action");
		//List<NewsVO> list = null;
		String keyin = request.getParameter("keyin");
		String searchmenu = request.getParameter("searchmenu");
		System.out.println("이건 넘어오나"+writer);
		
		if(id==null && action==null ) {
			List<NewsVO> list = dao.listAll();
			request.setAttribute("list", list);
		} else if(action !=null){
			List<NewsVO> list = dao.listAll();
			if(action.equals("read")) {
				NewsVO vo = dao.listOne(Integer.parseInt(id));
				request.setAttribute("come", vo);
				list = dao.listAll();
				request.setAttribute("list", list);
			} else if(action.equals("delete")) {
					dao.delete(Integer.parseInt(id));
					list = dao.listAll();
					request.setAttribute("list", list);
			} else if(action.equals("search") && !keyin.equals("")) {
				list=dao.search(keyin, searchmenu);
				request.setAttribute("list", list);
			} else if(action.equals("search") && keyin.equals("")) {
				list = dao.listAll();
				request.setAttribute("list", list);
			} else if(action.equals("listwriter")) {
				System.out.println("박명수니???"+writer);
				list=dao.listWriter(writer);
				System.out.println("리스트"+list);
				request.setAttribute("list", list);
			} else {
				request.setAttribute("msg", "해당 글이 존재하지 않슴돠");
			}
		}
		
		
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NewsVO vo = new NewsVO();
		NewsDAO dao = new NewsDAO();
		String action = request.getParameter("action");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writedate = request.getParameter("writedate");
		String id = request.getParameter("id");
		
		if(action.equals("insert")) {
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWritedate(writedate);
			vo.setCnt(0);
			boolean result = dao.insert(vo);
			
			if(result) {
				request.setAttribute("msg", "저장되었습니다.");
			} else {
				request.setAttribute("msg", "저장이 실패하였습니다.");
			}
		}
		
		if(action.equals("update")) {
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setId(Integer.parseInt(id));
			
			boolean result = dao.update(vo);
			System.out.println(content);
			if(result) {	
				request.setAttribute("msg", "수정되었습니다.");
			} else {
				request.setAttribute("msg", "수정에 실패하였습니다.");
			}
		}
		List<NewsVO> list = dao.listAll();
		request.setAttribute("list", list);

		
		
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
		
	}

}
