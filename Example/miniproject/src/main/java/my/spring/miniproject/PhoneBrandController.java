package my.spring.miniproject;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PhoneBrandController {
	

	@RequestMapping(value = "/phoneSAMSUNG", method = RequestMethod.GET)
	public String phoneSAMSUNG(Locale locale, Model model) {
	
		
		return "phoneSAMSUNG";
	}
	
	@RequestMapping(value = "/phoneLG", method = RequestMethod.GET)
	public String phoneLG(Locale locale, Model model) {

		
		return "phoneLG";
	}
	
	@RequestMapping(value = "/phoneAPPLE", method = RequestMethod.GET)
	public String phoneAPPLE(Locale locale, Model model) {

		
		return "phoneAPPLE";
	}
	
	@RequestMapping(value = "/phoneHUAWEI", method = RequestMethod.GET)
	public String phoneHUAWEI(Locale locale, Model model) {

		
		return "phoneHUAWEI";
	}
	
	@RequestMapping(value = "/phoneXIAOMI", method = RequestMethod.GET)
	public String phoneXIAOMI(Locale locale, Model model) {

		
		return "phoneXIAOMI";
	}
	
	@RequestMapping(value = "/phoneSONY", method = RequestMethod.GET)
	public String phoneSONY(Locale locale, Model model) {

		
		return "phoneSONY";
	}
	
	@RequestMapping(value = "/phoneGOOGLE", method = RequestMethod.GET)
	public String phoneGOOGLE(Locale locale, Model model) {


		return "phoneGOOGLE";
	}
	
}
