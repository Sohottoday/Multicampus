<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<h1> 미팅 스케쥴(JSTL) <a href="/mvc/htmlexam/meetingFormMybatis.html"><img src="/edu/images/home.jpg" width="80px" height="80px"></a> </h1>
<hr>
<c:forEach var="item" items="${list}"  varStatus="status">
<table>
	
	<tr>
		<td> <c:out value="${ item.name }"/></td>
		<td> <c:out value="${ item.title }"/></td>
		<td> <c:out value="${ item.meetingDate }"/></td>

		<td><a href="/mvc/meetingmybatis?action=delete&id=${item.id }">
		<img src="/edu/images/delete.png" width="30px" height="30px"></a></td> 
	</tr>
	
</table>
	</c:forEach>
<c:if test="${ !empty msg}">
<h2> ${msg}</h2>
</c:if>
<hr>

</body>
</html>