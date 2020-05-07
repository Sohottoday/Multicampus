<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int member_v = 0; %>       <%-- 멤버변수는 !를 주고 지역변수는 !없이 진행한다. --%>
<% 
	int local_v = 0; 
	member_v +=10;	
	local_v +=10;
%>
<ul>
	<li>멤버 변수 : <%= member_v %></li>
	<li>지역 변수 : <%= local_v %></li>
</ul>

</body>
</html>