package jdbcsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReadEmp {

	public static void main(String[] args) throws Exception {
				
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Statement stmt = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� �μ���ȣ�� �Է��ϼ��� : ");
		String num = scan.nextLine();
		scan.close();
		String sql = "SELECT ENAME, SAL, DEPTNO FROM EMP " + "where DEPTNO = '"+num+"'";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			do {
			System.out.println(rs.getString("ENAME")+":"+rs.getInt("SAL")+":"+rs.getInt("DEPTNO"));
			} while(rs.next());
		} else {
			System.out.println(num+"�� �μ��� �ٹ��ϴ� ������ �����ϴ�.");
		}
		System.out.println("=======End=========");
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
