package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List<NewsVO> listAll() {
		List<NewsVO> list = new ArrayList<>();
		connectDB();
		try (Statement stmt = connectDB().createStatement();
			ResultSet rs = stmt.executeQuery("select id, writer, title, writedate, cnt from news order by id desc");){
			NewsVO vo;
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
				
			}
			close(connectDB(),stmt,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
	}

	public NewsVO listOne(int id) {
		NewsVO vo = new NewsVO();
		connectDB();
		try (Statement stmt = connectDB().createStatement();
				ResultSet rs = stmt.executeQuery("select writer, title, content, id from news where id ="+id);){
		
			while(rs.next()) {
				
				vo.setWriter(rs.getString(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setId(rs.getInt(4));
			}
			close(connectDB(),stmt,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connectDB();
		try (PreparedStatement pstmt = connectDB().prepareStatement("update news set cnt = cnt+1 where id ="+id);){
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public boolean insert(NewsVO vo) {
		boolean result = true;
		connectDB();
		try(PreparedStatement pstmt = connectDB().prepareStatement("insert into news values(news_seq.nextval, ?, ?, sysdate, ?,?)");){
				pstmt.setString(1, vo.getWriter());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getCnt());
				pstmt.setString(4, vo.getTitle());
				pstmt.executeUpdate();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		connectDB();
		try(PreparedStatement pstmt = connectDB().prepareStatement("delete from news where id=?");) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean update(NewsVO vo) {
		boolean result = true;
		connectDB();
		try(PreparedStatement pstmt = connectDB().prepareStatement(
				"update news set "+
				"writer = ?, " +
				"title = ?, " +
				"writedate = sysdate, "+
				"content = ?" +
				"where id = ?");){
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;		
	}

	public List<NewsVO> listWriter(String writer){
		
		List<NewsVO> list = new ArrayList<>();
		connectDB();
		try ( Statement stmt = connectDB().createStatement();
				ResultSet rs = stmt.executeQuery("select id, writer, title, writedate, cnt from news where writer='"+writer+"' order by id desc");
				){
			while(rs.next()) {
				NewsVO vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
			}
			close(connectDB(),stmt,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("다오"+list);
		return list;
	}
	
	public List<NewsVO> search(String key, String searchType) {
		NewsVO vo = new NewsVO();
		List<NewsVO> list = new ArrayList<>();
		connectDB();
		
		if(searchType.equals("")){
			try (Statement stmt = connectDB().createStatement();
					ResultSet rs = stmt.executeQuery("select id, writer, title, writedate, cnt from news order by id desc");){
					while(rs.next()) {
						vo = new NewsVO();
						vo.setId(rs.getInt(1));
						vo.setWriter(rs.getString(2));
						vo.setTitle(rs.getString(3));
						vo.setWritedate(rs.getString(4));
						vo.setCnt(rs.getInt(5));
						list.add(vo);
						
					}
					close(connectDB(),stmt,rs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} else {
			if(searchType.equals("제목")) {
				try ( Statement stmt = connectDB().createStatement();
						ResultSet rs = stmt.executeQuery("select id, writer, title, writedate, cnt from news where title like '%"+key+"%'");
						){
					while(rs.next()) {
						vo.setId(rs.getInt(1));
						vo.setWriter(rs.getString(2));
						vo.setTitle(rs.getString(3));
						vo.setWritedate(rs.getString(4));
						vo.setCnt(rs.getInt(5));
						list.add(vo);
					}
					close(connectDB(), stmt, rs);
				} catch(SQLException e) {
					e.printStackTrace();
				}
			} else if(searchType.equals("작성자")) {
				try ( Statement stmt = connectDB().createStatement();
						ResultSet rs = stmt.executeQuery("select id, writer, title, writedate, cnt from news where writer like '%"+key+"%'");
						){
						while(rs.next()) {
							vo.setId(rs.getInt(1));
							vo.setWriter(rs.getString(2));
							vo.setTitle(rs.getString(3));
							vo.setWritedate(rs.getString(4));
							vo.setCnt(rs.getInt(5));
							list.add(vo);
						}
						close(connectDB(), stmt, rs);
					} catch(SQLException e) {
						e.printStackTrace();
					}
			} else if(searchType.equals("내용")) {
				try ( Statement stmt = connectDB().createStatement();
						ResultSet rs = stmt.executeQuery("select id, writer, title, writedate, cnt, content from news where content like '%"+key+"%'");
						){
						while(rs.next()) {
							vo.setId(rs.getInt(1));
							vo.setWriter(rs.getString(2));
							vo.setTitle(rs.getString(3));
							vo.setWritedate(rs.getString(4));
							vo.setCnt(rs.getInt(5));
							vo.setContent(rs.getString(6));
							list.add(vo);
						}
						close(connectDB(), stmt, rs);
					} catch(SQLException e) {
						e.printStackTrace();
					}
			} 
			}
		
		return list;
	}
}

