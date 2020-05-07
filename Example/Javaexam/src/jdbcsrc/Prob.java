package jdbcsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prob {

	public static void main(String[] args) 	throws SQLException, ClassNotFoundException {

		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			kaja("E");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void kaja(String fn) {
		String sql = "select first_name, last_name, salary from employees where first_name like '"+fn+"%'";
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
		if(rs.next()) {	
			do {
				System.out.println(rs.getString("first_name")+"("+rs.getString("last_name")+")"+"\t"+rs.getString("salary")+"원");
			} while(rs.next());
		} else {
			System.out.println("데이터가 없습니다.");
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException se){
			System.out.println("DB연동 오류 발생 : "+se.getMessage());
		}
	}
}
