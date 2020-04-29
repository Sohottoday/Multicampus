package edu.spring.redu;
import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rtest.OnePersonService;
@Controller
public class OnePersonController {
	@Autowired
	OnePersonService rl;
	
	@RequestMapping("/map7")
	public ModelAndView get8(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String real_path = req.getSession().getServletContext().getRealPath("/");
		System.out.println(real_path);
	    real_path = real_path.replace("\\", "/");
	    System.out.println(real_path);		
		File f = new File(real_path+"/resources/returnGu");
		if(!f.exists()) f.mkdir();
		String namegu = req.getParameter("namegu");
		if(namegu == null)
			namegu = "관악구";
		String result = rl.returnGu(real_path+"/resources/returnGu", namegu);
		mav.addObject("leafletChartName", "http://localhost:8000/redu/resources/returnGu/"+result);
		mav.setViewName("oneView");
		return mav;
	}	
}
