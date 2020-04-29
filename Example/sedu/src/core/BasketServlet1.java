package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter basketwrite = response.getWriter();
		String pid = request.getParameter("pid");	
		String path = "C:/logtest/";
		String filename = "mylog.txt";
		FileWriter writer = null;
		
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		
		File myfile=new File(path);
		if(!myfile.isDirectory()) {
			myfile.mkdirs();
		}
		
		try {
			writer = new FileWriter(path+filename,true);
			writer.write(ldt.format(dtf)+" "+pid+"\n");
			writer.close();
		} catch (IOException ioe) {
			ioe.getMessage();
		}
		basketwrite.print("{\"pid\" : \""+pid+"\"}");
		basketwrite.close();
	
	}

}
