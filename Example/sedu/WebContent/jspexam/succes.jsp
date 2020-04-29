<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
SimpleDateFormat sdf = new SimpleDateFormat("HH시mm분");
Date nowhour = new Date();
%>
<h1><%= sdf.format(nowhour) %>에 당첨 츄카츄카츄 $ㅅ$
아 근데 배가 너무아프네 증말루 이게 된다고?</h1>
<br>
<img src="http://70.12.115.178:8000/edu/images/nono.jpg" width="500" height="500">

</body>
</html>