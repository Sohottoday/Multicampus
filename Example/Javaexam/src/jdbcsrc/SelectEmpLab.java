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
		String sql = "select ename, to_char(sal, '9,999') sal, to_char(hiredate, 'yyyy\"��\" mm\"��\" dd\"��\"') hiredate from emp";
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				if (rd) {
					do {
						System.out.print(rs.getString("ename") + "������ ������ ");
						System.out.print(rs.getString("sal") + "���Դϴ�.");
						System.out.println();
					} while (rs.next());
				} else {
					do {
						System.out.print(rs.getString("ename") + "������ ");
						System.out.print(rs.getString("hiredate") + "���Դϴ�.");
						System.out.println();
					} while (rs.next());
				}
			}
		} catch (Exception e) {
			System.out.println("���� �߻� : "+e.getMessage());
		}
	}
}
