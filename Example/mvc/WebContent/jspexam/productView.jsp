<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.ProductVO" %>
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
<a href="http://localhost:8000/mvc/htmlexam/product.html">상품 선택 화면</a>
<hr>
<h1>선택된 상품의 정보는 다음과 같습니다.(액션 태그)</h1>
<jsp:useBean id="basket" class="model.vo.ProductVO" scope="session"/>
<hr>
<h2>선택된 갈매기살 : <jsp:getProperty name="basket" property="hanwoo1" />인분</h2>
<h2>선택된 차돌박이 : <jsp:getProperty name="basket" property="hanwoo2" />인분</h2>
<h2>선택된 안심 : <jsp:getProperty name="basket" property="hanwoo3" />인분</h2>
<hr>

<h1>선택된 상품의 정보는 다음과 같습니다.(표현언어EL)</h1>
<hr>
<h2>선택된 갈매기살 : ${ sessionScope.basket.hanwoo1 } 인분</h2>
<h2>선택된 차돌박이 : ${ sessionScope.basket.hanwoo2 } 인분</h2>
<h2>선택된 안심 : ${ sessionScope.basket.hanwoo3 } 인분</h2>
<hr>
</body>
</html>