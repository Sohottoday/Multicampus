package my.spring.springedu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.HadoopDAO3;
@Controller
public class HadoopController3 {
	@Autowired
	HadoopDAO3 dao;	
	public HadoopController3() {
		System.out.println("HadoopController3");
	}
	@RequestMapping("/hadoopmr")  
	public ModelAndView put(String action){
		String result = "";
		if(action.equals("mapreduce")) 
			result = dao.mapreduce();
		else if(action.equals("result")) 
			result = dao.mrresult();
		else 
			result = "Query 문자열을 확인해 주세요.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("hadooprw", result);
		mav.setViewName("hadoopView");		
		return mav;
	}	
}

