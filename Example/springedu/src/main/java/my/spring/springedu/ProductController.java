package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vo.ProductVO;

@Controller
@SessionAttributes("basket")
public class ProductController {
	@ModelAttribute("basket")
	public ProductVO baguni() {
		return new ProductVO();
	}
	
	@RequestMapping("/product")
	public String gogi(@ModelAttribute("basket")ProductVO vo, @RequestParam(value="pid", required=false)String pid, SessionStatus ss) {
		if(pid!=null&&pid.equals("del")) {
			ss.setComplete();
			return "clear";
		} else {
			return "productView";
		}	
	}
}