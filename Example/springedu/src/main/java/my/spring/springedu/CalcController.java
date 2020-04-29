package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

	@RequestMapping("/calc")
	public ModelAndView calc(@RequestParam("firstnum")int firstNum, @RequestParam("secondnum")int secondNum, @RequestParam("cal")String cal) {
		System.out.print("12");
		ModelAndView mav = new ModelAndView();
		
		if(cal.equals("/") && secondNum==0) {
			mav.addObject("number", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다.");
			mav.setViewName("errorResult");
		} else {
			int result=0;
			switch(cal) {
			case "+" : result = firstNum+secondNum;
			break;
			case "-" : result = firstNum-secondNum;
			break;
			case "*" : result = firstNum*secondNum;
			break;
			case "/" : result = firstNum/secondNum;
			break;
			}
			mav.addObject("number", result);
			mav.setViewName("calcResult");
		}
		
		return mav;
	}
}
