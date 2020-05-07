package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.VisitorVO;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class VisitorDAOTest {

	@Test
	void test() {
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.listAll();
		System.out.println(list.size());
		for(VisitorVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	void test1() {
		System.out.println("검색 기능 테스트");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("국밥");
		System.out.println(list.size());
		for(VisitorVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	void test2() {
		System.out.println("삽입 테스트");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("희동이");
		vo.setMemo("~~~오늘은 그냥 금요일___");
		boolean result = dao.insert(vo);
		if(result)
			System.out.println("삽입 성공");
		else
			fail("삽입실패");
	}

}

