package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.VisitorVO;

class VisitorDAOTest2 {

	@Test
	void test() {
		System.out.println("검색 기능 테스트");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("국밥");
		System.out.println(list.size());
		for(VisitorVO vo : list) {
			System.out.println(vo);
		}
	}

}
