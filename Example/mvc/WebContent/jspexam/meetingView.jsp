<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		text-align : middle;
	}
	table {
		border : 3px solid white;
		border-collapse : collapse;
	}
	tr {
		border : 3px dotted green;
		border-collapse : collapse;
	}
	td {
		margin : 5px;
	}

</style>
</head>
<body>
<%
	List<MeetingVO> list = (List<MeetingVO>)request.getAttribute("list"); 
%>
<h1> 미팅 스케쥴 <a href="/mvc/htmlexam/meetingForm.html"><img src="/edu/images/home.jpg" width="80px" height="80px"></a> </h1>
<hr>
<table>
<%
	for(MeetingVO vo : list) {
%>
	<tr>
		<td><%= vo.getName() %></td>
		<td><%= vo.getTitle() %></td>
		<td><%= vo.getMeetingDate() %></td>
		<td><a href="/mvc/meeting?action=delete&id=<%= vo.getId() %>">
		<img src="/edu/images/delete.png" width="30px" height="30px"></a>
	</tr>
	<%
	}
	%>
</table>
<h2> ${ requestScope.msg}</h2>
<hr>



</body>
</html>