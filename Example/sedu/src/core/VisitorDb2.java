package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/visitordb2")
public class VisitorDb2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out= response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
		}
		// DB 서버 접속, Statement 객체 생성, "select name, writedate, memo from visitor" SQL명령
		String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from visitor"; 
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();			
				ResultSet rs = stmt.executeQuery(sql);) {
			out.print("<h1>방명록 리스트</h1>");
			out.print("<table border='1'>");
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("writedate")+"</td>");
				out.print("<td>"+rs.getString("memo")+"</td>");
				out.print("</tr>");
			}
			
		} catch(SQLException e) {
			out.print("<h2>오류 발생 ㅠ</h2>");
			e.printStackTrace();
		}
		out.print("<hr><a href='/sedu/html/visitorMain.html'>방명록 메인화면으로 이동</a>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out= response.getWriter();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String memo = request.getParameter("memo");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
		}
		// DB 서버 접속, Statement 객체 생성, "select name, writedate, memo from visitor" SQL명령
		String sql = "insert into visitor values(?, sysdate, ?)"; 
		System.out.println(sql);
		try (	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(sql);	// preparedstatement -> sql을 집어 넣어야 한다.		
				) {	
			pstmt.setString(1, name);
			pstmt.setString(2, memo);
			pstmt.executeUpdate();      //sql 명령을 등록하면 안된다(미리 준비된 sql을 기동시키는 것이기 때문
			out.print("<h2>성공적으로 저장하였습니다</h2>");
		} catch(SQLException e) {
			out.print("<h2>방명록 저장 실패 ㅠ</h2>");
			e.printStackTrace();
		}
		out.print("<hr><a href='/sedu/html/visitorMain.html'>방명록 메인화면으로 이동</a>");
		out.close();
	}

}
