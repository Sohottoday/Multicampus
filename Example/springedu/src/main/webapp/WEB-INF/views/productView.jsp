<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ProductVO vo = (ProductVO)session.getAttribute("basket");
	%>
<h1>선택된 상품의 정보는 다음과 같습니다.(스크립트 태그)</h1>
<hr>
<h2>선택된 갈매기살 : <%= vo.getHanwoo1() %>인분</h2>
<h2>선택된 차돌박이 : <%= vo.getHanwoo2() %>인분</h2>
<h2>선택된 안심 : <%= vo.getHanwoo3() %>인분</h2>
<hr>
<a href="http://localhost:8000/springedu/resources/product.html">상품 선택 화면</a>

<hr>
</body>
</html>