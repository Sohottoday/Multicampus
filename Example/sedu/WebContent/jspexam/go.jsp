<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String ilovestudy = request.getParameter("study");	
if(ilovestudy==null) {
	out.println("<h2> 아무것도 입력하지 않았습니다.</h2>");
} else {
	switch(ilovestudy){
	case "javascript" : response.sendRedirect("http://www.w3schools.com/js/default.asp");
	break;
	case "dom" : response.sendRedirect("http://www.w3schools.com/js/js_htmldom.asp");
	break;
	case "ajax" : response.sendRedirect("http://www.w3schools.com/xml/ajax_intro.asp");
	break;
	case "json" : response.sendRedirect("http://www.w3schools.com/js/js_json_intro.asp");
	break;
	case "jsp" : 
%>
<jsp:forward page="/first.jsp">
	<jsp:param value="unico" name="gname"/>
</jsp:forward>
<%
	break;
	case "html" : 
%>
<jsp:forward page="/first.html"/>
<%	
	break;
	default : 
%>
<h2><%= ilovestudy %>로 전달된 이름이 존재하지 않습니다.</h2>
<%
	}
}
%>

</body>
</html>