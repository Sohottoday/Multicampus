package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.MeetingVO;

public class MeetingTest {

	@Test
	public void test() {
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName("라이언");
		vo.setTitle("화요일 저녁 6시에 만납시다!");	
		vo.setMeetingDate("2019-07-01T13:40");
		dao.insert(vo);
		List<MeetingVO> list = dao.listAll();
		for(MeetingVO data : list)
			System.out.println(data);
		System.out.println("화요일이 들어간 글**"); 
		list = dao.search("화요일");
		for(MeetingVO data : list)
			System.out.println(data);
	}
	
}
