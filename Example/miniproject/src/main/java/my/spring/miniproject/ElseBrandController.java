package my.spring.miniproject;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ElseBrandController {
	

	@RequestMapping(value = "/elseCAR", method = RequestMethod.GET)
	public String elseCAR(Locale locale, Model model) {


		
		return "elseCAR";
	}
	
	@RequestMapping(value = "/elseCAMERA", method = RequestMethod.GET)
	public String elseCAMERA(Locale locale, Model model) {


		
		return "elseCAMERA";
	}
	
	@RequestMapping(value = "/elseDRONE", method = RequestMethod.GET)
	public String elseDRONE(Locale locale, Model model) {


		
		return "elseDRONE";
	}
	
	@RequestMapping(value = "/elseEARPHONE", method = RequestMethod.GET)
	public String elseEARPHONE(Locale locale, Model model) {


		
		return "elseEARPHONE";
	}
	
	@RequestMapping(value = "/elseHEADPHONE", method = RequestMethod.GET)
	public String elseHEADPHONE(Locale locale, Model model) {


		
		return "elseHEADPHONE";
	}
	
	@RequestMapping(value = "/elseHOME", method = RequestMethod.GET)
	public String elseHOME(Locale locale, Model model) {


		
		return "elseHOME";
	}
	
	@RequestMapping(value = "/elseTV", method = RequestMethod.GET)
	public String elseTV(Locale locale, Model model) {


		
		return "elseTV";
	}
	
}
