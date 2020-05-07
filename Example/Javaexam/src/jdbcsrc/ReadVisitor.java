package jdbcsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadVisitor {

	public static void main(String[] args) throws Exception {
		/*1. JDBC Driver �ε� - Class.forName()
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. DBMS �� ���� - DriverManager.getConnection("jdbc url", "����", "��ȣ")
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		//"jdbc:oracle:thin:@70.12.115.178:1521:XE"
		
		System.out.println(conn);
		// 3. Statement/PreparedStatement ��ü ����
		Statement stmt = conn.createStatement();
		// 4. ó���Ϸ��� ��ɿ� ���� SQL ���� �����ϰ� �����Ų��.
		String sql = "select name, writedate, MEMO from VISITOR";
		ResultSet rs = stmt.executeQuery(sql);
		// 5. ��� ó��
		while(rs.next()) {
			System.out.println(rs.getString("name")+":"+rs.getDate("writedate")+":"+rs.getString("memo"));
		}
		System.out.println("=======End=========");
		rs.close();
		stmt.close();
		conn.close();
		*/
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		System.out.println(conn);
		Statement stmt = conn.createStatement();
		String sql = "select name, writedate, MEMO from VISITOR";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString("name")+":"+rs.getDate("writedate")+":"+rs.getString("memo"));
		}
		System.out.println("=======End=========");
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
