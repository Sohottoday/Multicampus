package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MeetingDAO;
import vo.MeetingVO;

@Controller
public class MeetingController {
	@Autowired
	MeetingDAO dao;

	// @RequestMapping("/meetingmybatis")
	protected String form() {
		return "meetingView_jstl_mybatis";
	}

	@RequestMapping("/meetingmybatis")
	protected ModelAndView goGet(MeetingVO vo, String keyword, String action) {
		ModelAndView mav = new ModelAndView();
		
		if (keyword == null) {
			if (vo.getId()!=0&&action.equals("delete")) {
				List<MeetingVO> list = dao.listAll();
				dao.delete(vo.getId());
				list = dao.listAll();
				mav.addObject("list", list);
			}
			
			List<MeetingVO> list = dao.listAll();
			mav.addObject("list", list);
			mav.setViewName("meetingView_jstl_mybatis");
			
		} else {
			List<MeetingVO> list = dao.search(keyword);
	
			if (list.size() == 0) {
				mav.addObject("msg", "담고있는 글이 음슴");
				mav.addObject("list", list);
				mav.setViewName("meetingView_jstl_mybatis");
			} else {
				mav.addObject("list", list);
				mav.setViewName("meetingView_jstl_mybatis");
			}
		}
		
		
		return mav;
	}

	@RequestMapping("/meetingmybatis2")
	protected ModelAndView goPost(MeetingVO vo) {
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list = dao.listAll();
		boolean result = dao.insert(vo);

		if (result) {
			mav.addObject("msg", vo.getName() + "님의 글이 저장되었습니다.");
			list = dao.listAll();

		} else {
			mav.addObject("msg", vo.getName() + "님의 글이 저장 실패.");
			list = dao.listAll();
			
		}
		mav.addObject("list", list);
		mav.setViewName("meetingView_jstl_mybatis");
		return mav;
		
	}
}
