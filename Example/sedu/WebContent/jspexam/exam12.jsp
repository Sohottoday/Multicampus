<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
</head>
<body>
<h2>include 지시자와 액션태그 비교</h2>
 <hr>
<%-- <%@ include file="date.jsp" %> --%>
<hr>
<%-- <%@ include file="date.jsp" %>  --%>
<hr>
<jsp:include page="date.jsp" />
<hr>
<jsp:include page="date.jsp" />
</body>
</html>
<!-- action 태그는 실행 결과만 가져오고 지시자태그는 전부 다 가져오는 것이라 ld라는 변수가 2번 중복 선언되서 문제가 됨 -->





