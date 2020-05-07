<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		width : 800px;
		margin-left : auto;
		margin-right : auto;
	}
	section {
		text-align : center;
	}

</style>
</head>
<body>
<% 
SimpleDateFormat sdf = new SimpleDateFormat("HH시mm분");
Date nowhour = new Date();
%>
<h1><%= sdf.format(nowhour) %>에 당첨 실패 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 그 돈이면 붕어빵이라도 한개 더 사먹겠닼ㅋㅋㅋㅋㅋㅋㅋㅋ 머어어어엉청한 판단 자아아아알 봤습니다 꺄르륵 꺄르륵</h1>

<section>
<img src="http://70.12.115.178:8000/edu/images/smile.jpg" width="300" height="300">
<br>
<br>
<a href="http://70.12.115.178:8000/sedu/html/lottoForm.html"><img src="/edu/images/restart.png"></a>
</section>
</body>
</html>