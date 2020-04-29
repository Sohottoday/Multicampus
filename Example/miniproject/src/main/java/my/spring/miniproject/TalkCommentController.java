package my.spring.miniproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.TalkCommentDAO;
import vo.TalkCommentVO;

@Controller
@RequestMapping("/comment")
public class TalkCommentController {
	
	@Autowired
	TalkCommentDAO commentdao= null;
	
	public List<TalkCommentVO> listAll() {
		List<TalkCommentVO> list = null;
		list = commentdao.listAll();
		return list;
	}

	@RequestMapping("/list")
	public ModelAndView commentlist() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", listAll());
		mav.setViewName("comment/list");

		return mav;
	}

	@RequestMapping("/delete")
	public ModelAndView commentDelete(int c_id) {
		ModelAndView mav = new ModelAndView();
		boolean result = commentdao.delete(c_id);
		if (result)
			System.out.println("컨트롤러com-삭제 성공");
		else
			System.out.println("컨트롤러com-삭제 실패");

		mav.addObject("list", listAll());
		mav.setViewName("comment/list");

		return mav;
		//return "redirect:/talk_listone"; 
	}

	
	@RequestMapping("/insert")
	public ModelAndView commentInsert(TalkCommentVO vo) {
		ModelAndView mav = new ModelAndView();
		System.out.print(vo.getContent());
		boolean result = commentdao.insert(vo);
		if (result)
			System.out.println("컨트롤러com-삽입 성공");
		else
			System.out.println("컨트롤러com-삽입 실패");

		mav.addObject("list", listAll());
		mav.setViewName("comment/list");

		return mav;
	}

	
	@RequestMapping("/update")
	public ModelAndView commentUpdate(TalkCommentVO vo) {
		ModelAndView mav = new ModelAndView();
		boolean result = commentdao.update(vo);
		if (result)
			System.out.println("컨트롤러com-업데이트 성공");
		else
			System.out.println("컨트롤러com-업데이트 실패");
		mav.addObject("list", listAll());
		mav.setViewName("comment/list");
		return mav;
		//return "redirect:/talk_listone";
	}

}
