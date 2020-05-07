package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController {
	@RequestMapping("/member")
	public ModelAndView Memberctr(MemberVO vo) {
		ModelAndView mav = new ModelAndView(); 
		String mname = vo.getName();
		String mphone = vo.getPhone();
		String mid = vo.getId();
		String mpass = vo.getPass();
		
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
		vo.setId(mid);
		vo.setName(mname);
		vo.setPass(mpass);
		vo.setPhone(mphone);
		mav.addObject("info", vo);
		mav.setViewName("memberView_2");
		return mav;
	}
}
