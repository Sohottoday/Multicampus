package vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeamVO {
	private String teamName;
	private ArrayList<TeamMemberVO> teamMember;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public ArrayList<TeamMemberVO> getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(ArrayList<TeamMemberVO> teamMember) {
		this.teamMember = teamMember;
	}

}
