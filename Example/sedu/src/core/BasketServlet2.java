package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter basketwrite = response.getWriter();
		
		String path = "C:/logtest/";
		String filename = "mylog.txt";
		FileWriter writer = null;
		String action = request.getParameter("action");
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		HttpSession session = request.getSession();

		if (action != null && action.equals("click")) {
			
			String pid = request.getParameter("pid");
			if (session.getAttribute("cnt") == null) {
				session.setAttribute("cnt", new int[11]);
			}
			int[] count = (int[]) session.getAttribute("cnt");

			File myfile = new File(path);
			if (!myfile.isDirectory()) {
				myfile.mkdirs();
			}
			
			try {
				writer = new FileWriter(path + filename, true);
				writer.write(ldt.format(dtf) + " " + pid + "\n");
				writer.close();
			} catch (IOException ioe) {
				ioe.getMessage();
			}
			
			switch (pid) {
			case "case":
				++count[0];
				break;
			case "cpu":
				++count[1];
				break;
			case "headset":
				++count[2];
				break;
			case "keyboard":
				++count[3];
				break;
			case "mainboard":
				++count[4];
				break;
			case "monitor":
				++count[5];
				break;
			case "mouse":
				++count[6];
				break;
			case "RTX 2080":
				++count[7];
				break;
			case "speaker":
				++count[8];
				break;
			case "standmic":
				++count[9];
				break;
			}
			
			HashMap<String, Integer> hashtable1 = new HashMap<String, Integer>();
			hashtable1.put("case", count[0]);
			hashtable1.put("cpu", count[1]);
			hashtable1.put("headset", count[2]);
			hashtable1.put("keyboard", count[3]);
			hashtable1.put("mainboard", count[4]);
			hashtable1.put("monitor", count[5]);
			hashtable1.put("mouse", count[6]);
			hashtable1.put("RTX 2080", count[7]);
			hashtable1.put("speaker", count[8]);
			hashtable1.put("standmic", count[9]);

			String nnn = "{";
			Iterator<String> keys = hashtable1.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				nnn += String.format("\"%s\" : \"%s\" ,", key, hashtable1.get(key));
			}
			nnn += "\"null\" : \"null\"}";
			basketwrite.print(nnn);
		}

		if (action != null && action.equals("destroy")) {
			
			String iii;
			session = request.getSession(false);  //
			
			if (session != null) {
				session.invalidate();
				iii = "{\"msg\" : \"상품이 삭제됨.\"}";
			} else {
				iii = "{\"msg\" : \"상품이 없는데? \"}";
			}
			basketwrite.print(iii);
		}

		basketwrite.close();
	}
}
