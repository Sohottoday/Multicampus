<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>요청을 처리하는 동안 오류가 발생했어요 ㅠ,.ㅠ</h1>
<h2>오류의 원인 : <%= request.getAttribute("number") %></h2>
<br><br>
<h2>오류의 원인 : ${ requestScope.number } </h2>
<br><br>
<a href="/mvc/htmlexam/calcForm.html">입력 화면</a>
</body>
</html>