package my.spring.springnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
public class NewsController {
	@Autowired
	NewsDAO dao;
	protected String from() {
		return "news";
	}
	
	@RequestMapping("newsmain")
	protected ModelAndView goGet(NewsVO vo, String action, String keyin, String searchmenu) {
		ModelAndView mav = new ModelAndView();
		if(action==null) {
			List<NewsVO> list = dao.listAll();
			mav.addObject("list", list);
		} else if(action!=null) {
			List<NewsVO> list = dao.listAll();
			if(action.equals("read")) {

				vo = dao.listOne(vo.getId());
				mav.addObject("come", vo);
				list = dao.listAll();
				mav.addObject("list", list);
			} else if(action.equals("delete")) {

				dao.delete(vo.getId());
				list = dao.listAll();
				mav.addObject("list", list);
			} else if(action.equals("search")&&!keyin.equals("")) {

				list=dao.search(keyin, searchmenu);
				mav.addObject("list", list);
			} else if(action.equals("search")&&keyin.equals("")) {

				list=dao.listAll();
				mav.addObject("list", list);
			} else if(action.equals("listwriter")) {

				list=dao.listWriter(vo.getWriter());
				mav.addObject("list", list);
			} else {
				mav.addObject("msg", "해당 글이 존재하지 않슴돠");
			}
		}
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping("newsmain2")
	protected ModelAndView goPost(NewsVO vo, String action) {
		ModelAndView mav = new ModelAndView();
		List<NewsVO> list = dao.listAll();
		
		if(action.equals("insert")) {
			boolean result = dao.insert(vo);
			
			if(result) {
				mav.addObject("msg", "저장되었습니다");
			} else {
				mav.addObject("msg", "저장에 실패하였습니다");
			}
		}
		
		if(action.equals("update")) {
			boolean result = dao.update(vo);
			
			if(result) {
				mav.addObject("msg", "수정되었습니다");
			} else {
				mav.addObject("msg", "수정에 실패하였습니다");
			}
		}
		
		list=dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("news");
		
		return mav;
	}

}
