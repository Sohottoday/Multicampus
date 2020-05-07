package model.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.vo.VisitorVO;

public class VisitorMybatisDAO2 {	
	final String resource = "resource/mybatis-config.xml"; // src 폴더 기준
	SqlSessionFactory sqlSessionFactory;
	public VisitorMybatisDAO2() {
		try {
		InputStream inputStream = 
				Resources.getResourceAsStream(resource);
			sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	
	public List<VisitorVO> listAll() {
		System.out.println("Mybatis 를 사용 DB 연동-listAll-DAO2");
		List<VisitorVO> list = null;		
		SqlSession session = sqlSessionFactory.openSession();
			String statement = "resource.VisitorMapper.selectVisitor";
			list = session.selectList(statement);
			System.out.println(session.getClass().getName());		
		
			session.close();
		
		return list;
	}
	public List<VisitorVO> search(String keyword) {
		System.out.println("Mybatis 를 사용 DB 연동-search-DAO2");
		List<VisitorVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
			String statement = "resource.VisitorMapper.searchVisitor";
			list = session.selectList(statement, keyword);
		
			session.close();
		return list;		
	}

	public boolean insert(VisitorVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-insert-DAO2");
		boolean result = false;
		SqlSession session = sqlSessionFactory.openSession(true);	//true를 주게 되면 자동서밋을 하게 만든다  mybatis는 기본적으로 오토커밋이 아니다. 
			String statement = "resource.VisitorMapper.insertVisitor";
			if(session.insert(statement, vo) == 1)			
				result = true;

				session.close();
		return result;
	}	
}
