<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>R 시각화 결과 표현하기</h1>
<hr>
<%
if(request.getAttribute("img_content") != null) {		
	byte content[] = (byte[])request.getAttribute("img_content");
%>
	<img src="
	   data:image/png;base64, <%= Base64.getEncoder().encodeToString(content) %>"	
	   width="500" height="400">	<!-- 데이터URL // Base64 => 바이너리 형식을 문자 형식으로 인코딩 해주는 메서드-->
<%
} 
%>	
</body>
</html>