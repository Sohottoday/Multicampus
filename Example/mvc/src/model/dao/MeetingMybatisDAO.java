package model.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.vo.MeetingVO;

public class MeetingMybatisDAO {	
	final String resource = "resource/mybatis-config.xml"; // src 폴더 기준
	SqlSessionFactory sqlSessionFactory;
	public MeetingMybatisDAO() {
		try {
		InputStream inputStream = 
				Resources.getResourceAsStream(resource);
			sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	
	public List<MeetingVO> listAll() {
		System.out.println("MeetingMybatis 를 사용 DB 연동-listAll-DAO");
		List<MeetingVO> list = null;		
		SqlSession session = sqlSessionFactory.openSession();
			String statement = "resource.MeetingMapper.selectMeeting";
			list = session.selectList(statement);
			System.out.println(session.getClass().getName());		
		
			session.close();
		
		return list;
	}
	public List<MeetingVO> search(String keyword) {
		System.out.println("Mybatis 를 사용 DB 연동-search-DAO");
		List<MeetingVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
			String statement = "resource.MeetingMapper.searchMeeting";
			list = session.selectList(statement, keyword);
		
			session.close();
		return list;		
	}

	public boolean insert(MeetingVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-insert-DAO");
		boolean result = false;
		SqlSession session = sqlSessionFactory.openSession(true);	//true를 주게 되면 자동서밋을 하게 만든다  mybatis는 기본적으로 오토커밋이 아니다. 
			String statement = "resource.MeetingMapper.insertMeeting";
			if(session.insert(statement, vo) == 1)			
				result = true;

				session.close();
		return result;
	}	
	
	public boolean delete(int eNo) {
		System.out.println("Mybatis 를 사용 DB 연동-delete-DAO");
		boolean result = false;
		SqlSession session = sqlSessionFactory.openSession(true);	//true를 주게 되면 자동서밋을 하게 만든다  mybatis는 기본적으로 오토커밋이 아니다. 
			String statement = "resource.MeetingMapper.deleteMeeting";
			if(session.delete(statement, eNo)==1)			
				result = true;

				session.close();
		return result;
	}	
	
	public boolean update(MeetingVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-update-DAO");
		boolean result = false;
		SqlSession session = sqlSessionFactory.openSession(true);	//true를 주게 되면 자동서밋을 하게 만든다  mybatis는 기본적으로 오토커밋이 아니다. 
			String statement = "resource.MeetingMapper.updateMeeting";
			if(session.update(statement, vo)==1)			
				result = true;

				session.close();
		
		return result;
	}
}
