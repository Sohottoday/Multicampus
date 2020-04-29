package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.LottoVO;



@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendnum = request.getParameter("sendnum");
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int [1]);
		}
		int [] session_v = (int[])session.getAttribute("cnt");
		session_v[0]+=1;
		int picknum = Integer.parseInt(sendnum);
		int rannum = (int)(Math.random()*6)+1;
		SimpleDateFormat sdf = new SimpleDateFormat("HH시mm분");
		Date nowhour = new Date();
		System.out.println("입력한 숫자 : "+picknum + "\n"+ "랜덤 숫자 : "+rannum);
		
		LottoVO vo = new LottoVO();
		if(session_v[0]>=4) {
			vo.setMsg("더 이상 응모할 수 없어요 ㅠㅠ 브라우저를 재기동한 후에 응모하세요");
		} else {
			if(picknum==rannum) {
				vo.setMsg(sdf.format(nowhour)+"에 당첨 츄카츄카츄 $ㅅ$\r\n" + 
						"아 근데 배가 너무아프네 증말루 이게 된다고?");
				vo.setImgUrl("http://70.12.115.178:8000/edu/images/nono.jpg");	
				session_v[0]=10;
			} else {
				vo.setMsg(sdf.format(nowhour)+"에 당첨 실패 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 그 돈이면 붕어빵이라도 한개 더 사먹겠닼ㅋㅋㅋㅋㅋㅋㅋㅋ 머어어어엉청한 판단 자아아아알 봤습니다 꺄르륵 꺄르륵");
				vo.setImgUrl("http://70.12.115.178:8000/edu/images/smile.jpg");
				vo.setLinkDisplay(true);
		}		
	}
		request.setAttribute("lotto", vo);
		RequestDispatcher impossible = request.getRequestDispatcher("/jspexam/lottoView.jsp");
		impossible.forward(request, response);
	}
}
