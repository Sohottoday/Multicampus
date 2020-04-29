package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TalkCommentVO;

@Repository
public class TalkCommentDAO{
	@Autowired
	SqlSession session = null;
	
	public List<TalkCommentVO> listAll() {
		System.out.println("Mybatis 를 사용 commDB 연동-listall ");
		List<TalkCommentVO> list = new ArrayList<TalkCommentVO>();
		String statement = "resource.TalkMapper.selectTalkComment";
		list = session.selectList(statement);
		return list;
	}
	public boolean insert(TalkCommentVO vo) {
		System.out.println("Mybatis 를 사용 commDB 연동-insert ");
		boolean result = false;
		String statement = "resource.TalkCommentMapper.insertTalkComment";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}
	
	
	public boolean update(TalkCommentVO vo) {
		System.out.println("Mybatis 를 사용 commDB 연동-update ");
		boolean result = false;
	
		String statement = "resource.TalkCommentMapper.updateTalkComment";
		if (session.update(statement, vo) == 1)
			result = true;

		return result;
	}


	public boolean delete(int eNo) {
		System.out.println("댓글 Mybatis 를 사용 commDB 연동-delete ");
		boolean result = false;
		String statement = "resource.TalkCommentMapper.deleteTalkComment";
		if (session.insert(statement, eNo) == 1)
			result = true;
 
		return result;
	}
	
	public TalkCommentVO listOne(int c_id) {
		System.out.println("Mybatis 를 사용 DB 연동-listOne ");
		String statement = "resource.TalkCommentMapper.selectOneTalkComment";
		TalkCommentVO searchOne = session.selectOne(statement, c_id);
		session.update(statement,searchOne);		
		return searchOne;
	}


	
	

}
