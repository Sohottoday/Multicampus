package my.spring.miniproject;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDAO;
import dao.ProductReviewDAO;
import vo.PagingControl;
import vo.ProdVO;
import vo.StarSelectVO;

@Controller
public class NotebookBrandController {
	
	@Autowired
	ProductDAO dao = null;
	@Autowired
	ProductReviewDAO redao =null;
	
	@RequestMapping(value = "/inProd", method = RequestMethod.GET)
	public String insertProd() {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("list", dao.listAll(11111));
//		mav.setViewName("prodBoard");

		return "insertProd";
	}
	
	@RequestMapping(value = "/insertProd", method = RequestMethod.POST)
	public String insertProd(ProdVO vo) {
		boolean result = dao.insert(vo);
		if (result)
			System.out.println("성공");
		else
			System.out.println("실패");

		System.out.print(vo.getPname());
		
		return "prodBoard";
	}
	@RequestMapping(value = "/uploadboard/{prodID}")
	public ModelAndView selectProd(@RequestParam(value="pagenum", defaultValue="1")int pagenum,
									@PathVariable String prodID) {
		ModelAndView mav = new ModelAndView();
		
		PagingControl paging = new PagingControl(pagenum);
		
		mav.addObject("prod", dao.selectOne(prodID));
		mav.addObject("paging", paging);
		mav.addObject("list", redao.listAll(prodID,paging));
		
		List<StarSelectVO> alphalist = redao.selectStar(prodID);
		
		int[] starlist = {0,0,0,0,0};
		int starcount = 0;
		float starsum = 0;
		
		for(int i=1;i<=5;i++) {
			for(int j=0;j<alphalist.size();j++) {
				if(alphalist.get(j).getViewStar()==i) {
					starlist[i-1]=alphalist.get(j).getCounting();
					starcount = starcount + alphalist.get(j).getCounting();
				    starsum = starsum + alphalist.get(j).getViewStar()*alphalist.get(j).getCounting();
				}
			}
		}
		
		mav.addObject("starlist",starlist);
		mav.addObject("starcount",starcount);
		mav.addObject("staravg",(starsum/starcount));
		mav.setViewName("uploadboard");
		return mav;
	}
	
	@RequestMapping(value = "/notebookSAMSUNG", method = RequestMethod.GET)
	public String notebookSAMSUNG(Locale locale, Model model, ProdVO vo) {
		ModelAndView mav = new ModelAndView();
		List<ProdVO> list = dao.listAllProd();
		mav.addObject("items", list);
		System.out.println(list);
		
		
		return "notebookSAMSUNG";
	}
	
	
	@RequestMapping(value = "/notebookLG", method = RequestMethod.GET)
	public String nobookLG(Locale locale, Model model) {
		
		return "notebookLG";
	}
	
	@RequestMapping(value = "/notebookAPPLE", method = RequestMethod.GET)
	public String notebookAPPLE(Locale locale, Model model) {

		
		return "notebookAPPLE";
	}
	
	@RequestMapping(value = "/notebookMSI", method = RequestMethod.GET)
	public String notebookMSI(Locale locale, Model model) {

		
		return "notebookMSI";
	}
	
	@RequestMapping(value = "/notebookHANSUNG", method = RequestMethod.GET)
	public String notebookHANSUNG(Locale locale, Model model) {
	
		
		return "notebookHANSUNG";
	}
	
	@RequestMapping(value = "/notebookASUS", method = RequestMethod.GET)
	public String notebookASUS(Locale locale, Model model) {
		
		
		return "notebookASUS";
	}
	
	@RequestMapping(value = "/notebookLENOVO", method = RequestMethod.GET)
	public String notebookLENOVO(Locale locale, Model model) {

		
		return "notebookLENOVO";
	}
	
}
