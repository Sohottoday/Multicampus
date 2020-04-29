package my.spring.miniproject;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TabletBrandController {
	

	@RequestMapping(value = "/tabletSAMSUNG", method = RequestMethod.GET)
	public String tabletSAMSUNG(Locale locale, Model model) {


		return "tabletSAMSUNG";
	}
	
	@RequestMapping(value = "/tabletLG", method = RequestMethod.GET)
	public String tabletLG(Locale locale, Model model) {


		return "tabletLG";
	}
	
	@RequestMapping(value = "/tabletAPPLE", method = RequestMethod.GET)
	public String tabletAPPLE(Locale locale, Model model) {


		return "tabletAPPLE";
	}
	
	@RequestMapping(value = "/tabletHUAWEI", method = RequestMethod.GET)
	public String tabletHUAWEI(Locale locale, Model model) {


		return "tabletHUAWEI";
	}
	
	@RequestMapping(value = "/tabletTECLAST", method = RequestMethod.GET)
	public String tabletTECLAST(Locale locale, Model model) {


		return "tabletTECLAST";
	}
	
	@RequestMapping(value = "/tabletASUS", method = RequestMethod.GET)
	public String tabletASUS(Locale locale, Model model) {


		return "tabletASUS";
	}
	
	@RequestMapping(value = "/tabletLENOVO", method = RequestMethod.GET)
	public String tabletLENOVO(Locale locale, Model model) {


		return "tabletLENOVO";
	}
	
}
