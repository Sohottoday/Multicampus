package jdbcsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {

		boolean rd = new Random().nextBoolean();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select ename, to_char(sal, '9,999') sal, to_char(hiredate, 'yyyy\"년\" mm\"월\" dd\"일\"') hiredate from emp";
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				if (rd) {
					do {
						System.out.print(rs.getString("ename") + "직원의 월급은 ");
						System.out.print(rs.getString("sal") + "원입니다.");
						System.out.println();
					} while (rs.next());
				} else {
					do {
						System.out.print(rs.getString("ename") + "직원은 ");
						System.out.print(rs.getString("hiredate") + "원입니다.");
						System.out.println();
					} while (rs.next());
				}
			}
		} catch (Exception e) {
			System.out.println("오류 발생 : "+e.getMessage());
		}
	}
}
