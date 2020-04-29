<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연산 요청 결과</h1>
<hr>
<h2>결과 : <%= request.getAttribute("number") %></h2>
<br><br>
<h1>연산 요청 결과(EL)</h1>
<hr>
<h2>결과 : ${ requestScope.number } </h2>
<br><br>
<a href="/springedu/resources/calcFormSpring.html">입력 화면</a>

</body>
</html>