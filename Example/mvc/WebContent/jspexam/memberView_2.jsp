<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.MemberVO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스크립트 태그</h1>
<%
	MemberVO vo = (MemberVO)request.getAttribute("info");
%>
<h1>회원 정보</h1>
<hr>
<ul>

	<li>회원 이름 : <%= vo.getName() %>
	</li>
	<li>회원 계정 : <%= vo.getId() %>
	</li>
	<li>회원 암호 : <%= vo.getPass() %>
	</li>
	<li>회원 전화번호 : <%= vo.getPhone() %>
	</li>

</ul>
<hr>
<h1>액션 태그</h1>
<jsp:useBean id="info" class="model.vo.MemberVO" scope="request"/>
<h1>회원 정보</h1>
<hr>
<ul>

	<li>회원 이름 : <jsp:getProperty name="info" property="name"/>
	</li>
	<li>회원 계정 : <jsp:getProperty name="info" property="id"/>
	</li>
	<li>회원 암호 : <jsp:getProperty name="info" property="pass"/>
	</li>
	<li>회원 전화번호 : <jsp:getProperty name="info" property="phone"/>
	</li>

</ul>
<hr>
<h1>표현 언어(EL)</h1>

<h1>회원 정보</h1>
<hr>
<ul>

	<li>회원 이름 : ${ requestScope.info.name }
	</li>
	<li>회원 계정 : ${ requestScope.info.id }
	</li>
	<li>회원 암호 : ${ requestScope.info.pass }
	</li>
	<li>회원 전화번호 : ${ requestScope.info.phone }
	</li>

</ul>
<hr>
</body>
</html>