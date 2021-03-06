package rtest;

import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Repository;

@Repository
public class ROracleDAO1 {
	public String returnDBData(int type) {
		String retStr = "";
		RConnection r = null;
		try {
			r = new RConnection();			
			r.eval("library(DBI)");
			r.eval("library(RJDBC)");
			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','c:/Sohottoday/ojdbc6.jar')");
			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
			if( type == 1)
				r.eval("query = 'SELECT * FROM VISITOR'");
			else if (type == 2)
				r.eval("query = 'SELECT * FROM VISITOR order by name'");
			RList list = r.eval("dbGetQuery(conn,query)").asList();
			int cols = list.size();
			int rows = list.at(0).length();
			String[][]s = new String[cols][];
			for(int i=0; i<cols; i++) {
				s[i] = list.at(i).asStrings();				
			}
			for(int j=0; j<rows; j++) {
				for(int i=0; i<cols; i++) {
					retStr += (s[i][j])+"";
				}
				retStr += "</br>";
			}			
		} catch(Exception e) {
			System.out.println(e);
			retStr = "오류 발생!!";
		} finally {
			r.close();
		}
		return retStr;
	}
	public String returnDBData(String name) {
		String retStr = "";
		RConnection r = null;
		System.out.println("---->"+name);
		try {
			r = new RConnection();			
			r.eval("library(DBI)");
			r.eval("library(RJDBC)");
			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','c:/Sohottoday/ojdbc6.jar')");
			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
			r.eval("query <- 'SELECT * FROM VISITOR WHERE NAME = "+name+"'"); 
			RList list = r.eval("dbGetQuery(conn,query)").asList();
			int cols = list.size();
			int rows = list.at(0).length();
			String[][]s = new String[cols][];
			for(int i=0; i<cols; i++) {
				s[i] = list.at(i).asStrings();				
			}
			for(int j=0; j<rows; j++) {
				for(int i=0; i<cols; i++) {
					retStr += (s[i][j])+"";
				}
				retStr += "</br>";
			}					
		} catch(Exception e) {
			System.out.println(e);
			retStr = "오류 발생!!";
		} finally {
			r.close();
		}
		return retStr;
	}
	public String insertDBData(String name, String content) {
		String retStr = "";
		RConnection r = null;
		System.out.println("---->"+name);
		System.out.println("---->"+content);
		try {
			r = new RConnection();			
			r.eval("library(DBI)");
			r.eval("library(RJDBC)");
			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','c:/Sohottoday/ojdbc6.jar')");
			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
			r.eval("insertSQL <- 'INSERT INTO visitor VALUES ("+name+",sysdate,"+content+")'");
			r.eval("dbSendUpdate (conn, insertSQL)");
			retStr = r.eval("'정상적으로 저장되었어요..'").asString();			
		} catch(Exception e) {
			System.out.println(e);
			retStr = "오류 발생!!";
		} finally {
			r.close();
		}
		return retStr;
	}
}
