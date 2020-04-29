<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO)request.getAttribute("info");
%>
<h1>회원 정보</h1>
<hr>
<ul>
<%
	String mname=vo.getName();
	String mphone=vo.getPhone();
	String mid=vo.getId();
	String mpass=vo.getPass();
%>
	<li>회원 이름 : <%= mname %>
	</li>
	<li>회원 계정 : <%= mid %>
	</li>
	<li>회원 암호 : <%= mpass %>
	</li>
	<li>회원 전화번호 : <%= mphone %>
	</li>

</ul>

</body>
</html>