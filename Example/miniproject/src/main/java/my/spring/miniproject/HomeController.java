package my.spring.miniproject;


import java.util.Locale;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;




@Controller
public class HomeController {

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		return "home";
	}
	@RequestMapping(value = "/uploadboard", method = RequestMethod.GET)
	public ModelAndView uploadboard() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("uploadboard");

		return mav;
	}
	
	@RequestMapping(value = "/prodBoard", method = RequestMethod.GET)
	public String prodBoard() {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("list", dao.listAll(11111));
//		mav.setViewName("prodBoard");

		return "prodBoard";
	}
	
	@RequestMapping(value = "/insertProd", method = RequestMethod.GET)
	public String insertProd() {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("list", dao.listAll(11111));
//		mav.setViewName("prodBoard");

		return "insertProd";
	}
	
	
	
}
