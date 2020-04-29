package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
	@RequestMapping("/eduspring")
	public ModelAndView EduC(@RequestParam("avgnum")int avgnum) {
		  ModelAndView mav = new ModelAndView();

		if(avgnum>=90) {
			mav.setViewName("gradeA2");			
		} else if(avgnum >=80 && avgnum <90) {
			mav.setViewName("gradeB");			
		} else if(avgnum >=70 && avgnum <80) {
			mav.setViewName("gradeC");			
		} else {
			mav.setViewName("gradeD");			
		}
		return mav;
	}

}
