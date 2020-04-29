package my.spring.miniproject;


import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TabletMenuController {
	

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/tabletMenu", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {


		return "tabletMenu";
	}
	
}
