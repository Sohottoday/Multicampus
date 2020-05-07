package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.StepVO;
// POJO
@Controller
public class StepController {		
	@RequestMapping(value="/step",
			 method=RequestMethod.POST)
	public String memberHandle(@ModelAttribute("kkk") StepVO vo) {	// StepVO 객체를 kkk라는 이름으로 저장한다는 뜻 , String으로 return하는 것은 return값의 jsp로 이동한다는 뜻
		if(vo.getAge() < 18)
			return "redirect:/resources/stepForm.html";		//redirect: 을 통해 이동시키기 가능(같은 컨텐츠 안에서만 가능) 
		System.out.println("[ Information for the passed Command object ]");
		System.out.println(vo.getName());
		System.out.println(vo.getPhoneNumber());
		System.out.println(vo.getAge());
		return  "stepOutput";
	}
}
