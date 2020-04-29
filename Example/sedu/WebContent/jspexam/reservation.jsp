<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
	request.setCharacterEncoding("UTF-8");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	Date now = new Date();	
	String [] rplus = request.getParameterValues("plus");
	%>
	
<h1><%= request.getParameter("rname")%>님의 예약 내용</h1>
<hr>
<ul>
	<li> 룸 : <%= request.getParameter("rroom") %>
	<li> 추가 요청 사항 : 
	<%
	for(String plus : rplus) {
	%>
	<%= (plus+" ")
	%>
	<% } %>
	<li> 예약날짜 : <%= sdf.format(now) %>
</ul>
<a href="/sedu/html/reservation2.html">예약 입력 화면으로</a>

</body>
</html>