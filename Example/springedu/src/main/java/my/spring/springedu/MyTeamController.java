package my.spring.springedu;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.TeamMemberVO;
import vo.TeamVO;

@Controller
public class MyTeamController {
	
	@RequestMapping(value="/myteam/json", produces="application/json; charset=utf-8")
	@ResponseBody
	public TeamVO getJson() {
		ArrayList<TeamMemberVO> list = new ArrayList<>();
		
		TeamMemberVO team1 = new TeamMemberVO();
		team1.setName("민세미");
		team1.setNicName("미스 쵸콜릿");
		
		TeamMemberVO team2 = new TeamMemberVO();
		team2.setName("이찬우");
		team2.setNicName("아니요");
		
		TeamMemberVO team3 = new TeamMemberVO();
		team3.setName("최성연");
		team3.setNicName("??");
		
		list.add(team1);
		list.add(team2);
		list.add(team3);
		
		TeamVO vo = new TeamVO();
		vo.setTeamName("겟잇뷰티(Get IT reView Together)");
		vo.setTeamMember(list);
		
		return vo;
	}
	
	@RequestMapping(value="/myteam/xml", produces="application/xml; charset=utf-8")
	@ResponseBody
	public TeamVO getXml() {
ArrayList<TeamMemberVO> list = new ArrayList<>();
		
		TeamMemberVO team1 = new TeamMemberVO();
		team1.setName("민세미");
		team1.setNicName("???");
		
		TeamMemberVO team2 = new TeamMemberVO();
		team2.setName("이찬우");
		team2.setNicName("아니요");
		
		TeamMemberVO team3 = new TeamMemberVO();
		team3.setName("최성연");
		team3.setNicName("??");
		
		list.add(team1);
		list.add(team2);
		list.add(team3);
		
		TeamVO vo = new TeamVO();
		vo.setTeamName("겟잇뷰티");
		vo.setTeamMember(list);
		
		return vo;
	}
}
