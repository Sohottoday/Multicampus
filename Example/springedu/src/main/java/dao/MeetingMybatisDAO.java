package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MeetingVO;

@Repository //데이터를 직접적으로 다루는 컴포넌트일때 명시하고자 붙임
public class MeetingMybatisDAO implements MeetingDAO {	
	
	@Autowired
	SqlSession session=null;	//세션 변수가 자동으루 주입된다. close도 필요 없어진다.

	
	
	public List<MeetingVO> listAll() {
		List<MeetingVO> list = null;		
			String statement = "resource.MeetingMapper.selectMeeting";
			list = session.selectList(statement);
		
		return list;
	}
	public List<MeetingVO> search(String keyword) {
		System.out.println("Mybatis 를 사용 DB 연동-search-DAO");
		List<MeetingVO> list = null;
			String statement = "resource.MeetingMapper.searchMeeting";
			list = session.selectList(statement, keyword);

		return list;		
	}

	public boolean insert(MeetingVO vo) {
		boolean result = false; 
			String statement = "resource.MeetingMapper.insertMeeting";
			if(session.insert(statement, vo) == 1)			
				result = true;

		return result;
	}	
	
	public boolean delete(int eNo) {
		boolean result = false;
		System.out.print(eNo);
			String statement = "resource.MeetingMapper.deleteMeeting";
			if(session.delete(statement, eNo)==1)			
				result = true;

		return result;
	}	
	
	public boolean update(MeetingVO vo) {
		boolean result = false; 
			String statement = "resource.MeetingMapper.updateMeeting";
			if(session.update(statement, vo)==1)			
				result = true;
		return result;
	}
}
