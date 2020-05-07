package my.spring.miniproject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDAO;
import dao.ProductReviewDAO;
import vo.LoginVO;
import vo.ProdReviewVO;
import vo.ProdVO;


@Controller
public class NotebookMenuController {

	@Autowired
	ProductReviewDAO dao = null;
	
	@Autowired
	ProductDAO prodao = null;

	@RequestMapping(value = "/notebookMenu", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {


		return "notebookMenu";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView boardWrite(String prodID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prodID", prodID);
		mav.setViewName("boardWrite");
		return mav;
	}

	@RequestMapping(value = "/viewReview", method = RequestMethod.GET)
	public ModelAndView boardWrite(HttpSession session, int reViewID, String prodID) {
		ModelAndView mav = new ModelAndView();
		ProdVO prodvo = prodao.selectOne(prodID);
		mav.addObject("prodvo", prodvo);
		mav.addObject("item", dao.selectOne(reViewID));
		mav.setViewName("viewReview");

		return mav;
	}
	
	@RequestMapping(value = "/viewReview/update", method = RequestMethod.GET)
	public ModelAndView boardUpdate(int reViewID, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("item", dao.selectOne(reViewID));
		mav.setViewName("boardUpdate");
		
		return mav;
	}
	
	@RequestMapping(value = "/viewReview/updatetwo", method = RequestMethod.POST)
	public String boardUpdatetwo(ProdReviewVO vo, HttpSession session) {
		LoginVO login = (LoginVO) (session.getAttribute("login"));
//		System.out.print("????:"+vo.getProdID());
//		System.out.print(login.getIDCord()+"\t"+ViewStar);
		vo.setIdCord(login.getIDCord());
		vo.setNickName(login.getNickName());
		vo.setIdEmail(login.getIDEmail());
		System.out.print(vo.getViewStar());
//		System.out.print(vo.getViewStar());
		boolean result = dao.update(vo);
		if (result)
			System.out.println("성공");
		else
			System.out.println("실패");
//		System.out.print(prodao.selectOne(vo.getProdID()).getPName());
//		System.out.print(vo.getViewContenxt());
		return "redirect:/viewReview?reViewID=" + vo.getReViewID() + "&prodID=" + vo.getProdID();
	}

	@RequestMapping(value = "/viewReview/delete", method = RequestMethod.GET)
	public String reViewDelete(int reViewID, HttpSession session) {

//		System.out.println("11111" + (LoginVO) (session.getAttribute("login")));

		ProdReviewVO vo = dao.selectOne(reViewID);
		if (session.getAttribute("login") != null) {
			if (((LoginVO) (session.getAttribute("login"))).getIDCord() != vo.getIdCord()) {
				System.out.print("안됨");
			} else {
				boolean result = dao.delete(reViewID);
				if (result)
					System.out.println("성공");
				else
					System.out.println("실패");
			}
		}
		return "redirect:/uploadboard/" + vo.getProdID();

	}

	@RequestMapping(value = "/write1", method = RequestMethod.POST)
	public String upboardWrite(ProdReviewVO vo, HttpSession session, int ViewStar) {
		LoginVO login = (LoginVO) (session.getAttribute("login"));
//		System.out.print(login.getIDCord()+"\t"+ViewStar);
		vo.setIdCord(login.getIDCord());
		vo.setNickName(login.getNickName());
		vo.setIdEmail(login.getIDEmail());
		vo.setViewStar(ViewStar);
		System.out.print(vo.getViewStar());
		boolean result = dao.insert(vo);
		if (result)
			System.out.println("성공");
		else
			System.out.println("실패");

//		System.out.print(vo.getViewContenxt());
		return "redirect:uploadboard/" + vo.getProdID();
	}

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/image", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String saveFile(MultipartRequest mreq) {

		String fileInfo = null;
		ModelAndView mav = new ModelAndView();
		List<MultipartFile> list = mreq.getFiles("file");
		String resultStr = "";
		mav.setViewName("boardWrite");

		for (MultipartFile mfile : list) {

			String fileName = mfile.getOriginalFilename();
			try {

				fileInfo = context.getRealPath("/") + "resources/img/" + fileName;
				File f = new File(fileInfo);
				System.out.println(fileInfo);
				if (f.exists()) {
					resultStr = "/miniproject/resources/img/" + fileName;
				} else {
					mfile.transferTo(new File(fileInfo));
					resultStr = "/miniproject/resources/img/" + fileName;
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return resultStr;
	}

}
