package my.spring.springedu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.SparkDAO;
@Controller
public class SparkController {
	@Autowired
	SparkDAO dao;	

	@RequestMapping("/sparktest")  
	public ModelAndView list(){		 
		String result = dao.sparkProc();
		ModelAndView mav = new ModelAndView();
		mav.addObject("sparkResult", result);
		mav.setViewName("sparkView");		
		return mav;
	}	
}

