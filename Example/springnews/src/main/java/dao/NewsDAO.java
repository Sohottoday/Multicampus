package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;
@Repository
public class NewsDAO {
	
	@Autowired
	SqlSession session=null;
	
		public List<NewsVO> listAll() {
		List<NewsVO> list = null;//new ArrayList<>();

		String statement = "resource.NewsMapper.selectNews";
		list = session.selectList(statement);
		
			return list;
	}

	public NewsVO listOne(int id) {
		NewsVO vo = new NewsVO();
		
		String statement = "resource.NewsMapper.listoneNews";
		vo= session.selectOne(statement, id);
		
		boolean result = false;
		String statements = "resource.NewsMapper.listonecntNews";
		if(session.update(statements, vo)==1)
			result = true;
			
		return vo;
	}
	
	public boolean insert(NewsVO vo) {
		boolean result = false;
			String statement = "resource.NewsMapper.insertNews";
			if(session.insert(statement, vo) == 1)			
				result = true;

		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
			String statement = "resource.NewsMapper.deleteNews";
			if(session.delete(statement, id)==1)			
				result = true;

		return result;
	}

	public boolean update(NewsVO vo) {
		boolean result = false; 
			String statement = "resource.NewsMapper.updateNews";
			if(session.update(statement, vo)==1)			
				result = true;

		return result;
	}

	public List<NewsVO> listWriter(String writer){
		List<NewsVO> list = null;//new ArrayList<>();
		String statement = "resource.NewsMapper.selectWriter";
		list = session.selectList(statement,writer);
		return list;
	}
	
	public List<NewsVO> search(String keyin, String searchmenu) {
		List<NewsVO> list = null;//new ArrayList<>();
		System.out.println("11"+keyin+"$$"+searchmenu);
		if(keyin.equals("")){
			String statement = "resource.NewsMapper.selectNews";
			list = session.selectList(statement);
			
		} else {
			if(searchmenu.equals("제목")) {
				String statement = "resource.NewsMapper.searchTitle";
				list = session.selectList(statement,keyin);
				
			} else if(searchmenu.equals("작성자")) {
				
				String statement = "resource.NewsMapper.searchWriter";
				list = session.selectList(statement,keyin);
				
			} else if(searchmenu.equals("내용")) {
				String statement = "resource.NewsMapper.searchContent";
				list = session.selectList(statement,keyin);
			} 
		}
		System.out.println("리스트다"+list);
		return list;
	}
}

