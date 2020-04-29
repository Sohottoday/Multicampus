<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
	<h1><%=	request.getParameter("name") %>님은 D등급 입니다. 뭐하세요?? -0-? </h1>
	<br><br>
	<a href="/mvc/htmlexam/eduForm.html">성적 입력 화면으로</a>

</body>
</html>