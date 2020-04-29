package my.spring.springedu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.LottoService;
import vo.LottoCntVO;
import vo.LottoVO;
@Controller
@SessionAttributes("box")
public class LottoController2 {
	@Autowired
	private LottoService lottoService;	
	@ModelAttribute("box")
	public LottoCntVO cnt() {
		return new LottoCntVO();
	}
	@RequestMapping("/lotto2")
	public String lottoProcess(LottoVO vo, @ModelAttribute("box")LottoCntVO cnt) {		
		if(cnt.getLottoCnt()>=4) {
			vo.setResult("더이상 응모할 수 없습니다. 브라우저를 재가동하세유");
		} else {
			if (lottoService.getLottoProcess(vo.getLottoNum())) {
				vo.setResult("추카추카!!");
				cnt.setLottoCnt(10);
			} else {
				vo.setResult("아쉽네요 .. 다음 기회를!!");
				cnt.setLottoCnt(1);
			}
		}
		return "lottoView2";
	}
}



