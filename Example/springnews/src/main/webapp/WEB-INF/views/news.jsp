<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.NewsVO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin : 0px;
	}
	a {
		text-decoration : none;
	}
	h1 {
		font-size : 2.5em;
		color : blue;
		text-align : center;
	}
	#rightart {
		width : 70%;
		float : right;
		margin-left : auto;
		text-align : center;
	}
	#leftart {
		width : 30%;
		float : left;
		text-align : center;
		margin-right : auto;
		margin-left : auto;
	}
	tr {
		
	}
	td {
		text-align : center;
		border-bottom-style : dotted;
		border-color : black;
	}
	tr:hover {
		background-color : yellow;
	}
	#butright {
		clear : both;
		text-align : right;
	}
	#find {
		text-align : right;
	}
	.good , #del {
	 display: inline-block;
  	vertical-align: top;
  	height: 48px;
  	line-height: 46px;
  	padding: 0 25px;
  	font-family: inherit;
  	font-size: 15px;
  	color: #bbb;
  	text-align: center;
  	text-decoration: none;
  	text-shadow: 0 0 2px rgba(0, 0, 0, 0.7);
  	background-color: #303030;
  	background-clip: padding-box;
  	border: 1px solid;
  	border-color: #202020 #1a1a1a #111;
  	border-radius: 25px;
  	background-image: -webkit-linear-gradient(top, #3d3d3d, #272727);
  	background-image: -moz-linear-gradient(top, #3d3d3d, #272727);
  	background-image: -o-linear-gradient(top, #3d3d3d, #272727);
  	background-image: linear-gradient(to bottom, #3d3d3d, #272727);
  	-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.09), 0 1px 3px rgba(0, 0, 0, 0.3);
  	box-shadow: inset 0 1px rgba(255, 255, 255, 0.09), 0 1px 3px rgba(0, 0, 0, 0.3);
	}
	.good:hover {
  	background-color: #363636;
  	background-image: -webkit-linear-gradient(top, #404040, #2a2a2a);
  	background-image: -moz-linear-gradient(top, #404040, #2a2a2a);
  	background-image: -o-linear-gradient(top, #404040, #2a2a2a);
  	background-image: linear-gradient(to bottom, #404040, #2a2a2a);
	}
	body {
		position : relative;
		z-index : 1;
	}
	body:after {
		background-image : url("http://70.12.115.178:8000/mvc/images/seoul.png");
		/* background-repeat : no-repeat; */
		brackground-size : cover;
		top : 0;
		left : 0;
		position : absolute;
		opacity : 0.5!important;
		filter:alpha(opacity=50);
		z-index:-1;
		content:"";
		width : 100%;
		height : 100%;
		
	}
	#howcan {
		weight : 70%;
		/* color :DodgerBlue; */
		text-align : center;
		margin-left : auto;
		margin-right : auto;
	}
	#write {
		weight : 70%;
		/* color : red; */
		text-align : center;
		margin-left : auto;
		margin-right : auto;
	}
	#mname, #mtitle, #mcontent, .box {
		border-style : solid;
		border-width : 2px 2px 2px 8px;
		word-break : break-all;
		border-color : LightSalmon;
	}
	
</style>
</head>
<body>
<%
	List<NewsVO> list = (List<NewsVO>)request.getAttribute("list");
	NewsVO listone = (NewsVO)request.getAttribute("come");
	
%>
	<h1><a href="http://70.12.115.178:8000/springnews/newsmain"><img src="http://70.12.115.178:8000/mvc/images/newslogo.jpg" width="300px" height="100px"></a></h1>
<div id="find">
<form method="get" action="http://70.12.115.178:8000/springnews/newsmain">
	<input type="hidden" name="action" value="search">
	<select name="searchmenu">
		<option value="제목">제목</option>
		<option value="작성자">작성자</option>
		<option value="내용">내용</option>
	</select>
	<input type="text" name="keyin" >
	<input type="submit" value="검색">
	
</form>
</div>
	
<section>
<article id="rightart">
	<table>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
	<%
		for(NewsVO vo : list) {
	%>
	<tr>
	<td width="80px" class='<%=vo.getId() %>'><%= vo.getId() %></td>
	<td  width="300px" onclick="location.href='http://70.12.115.178:8000/springnews/newsmain?action=read&id=<%=vo.getId() %>'"><%=vo.getTitle() %></td>
	<%-- <td class='<%=vo.getId() %>' onclick="change(<%=vo.getId()%>,<%=vo.getContent()%>);"><%= vo.getTitle() %></td> --%>
	<td  width="150px" onclick="location.href='http://70.12.115.178:8000/springnews/newsmain?action=listwriter&writer=<%=vo.getWriter() %>'"><%= vo.getWriter() %></td>
	<td  width="180px" class='<%=vo.getId() %>'><%= vo.getWritedate() %></td>
	<td  width="50px" class='<%=vo.getId() %>'><%= vo.getCnt() %></td>
	</tr>
	<%
		}
	%>
	</table>
</article>
<aside id="leftart">
	<a href="http://www.naver.com" target="_blank"><img src="http://70.12.115.178:8000/mvc/images/naverlogo.png" width="180px" height="80px"></a><br>
	<a href="https://sports.news.naver.com/basketball/index.nhn" target="_blank"><img src="http://70.12.115.178:8000/mvc/images/nbalogo.png" width="180px" height="80px"></a><br>
	<a href="https://sports.news.naver.com/wbaseball/index.nhn" target="_blank"><img src="http://70.12.115.178:8000/mvc/images/mlblogo.png" width="180px" height="80px"></a><br>
	<a href="https://www.multicampus.com/main" target="_blank"><img src="http://70.12.115.178:8000/mvc/images/multilogo.png" width="180px" height="80px"></a>
</aside>	
</section>	

	<h3>${msg}</h3>
	
	<%-- <a href='/mvc/news?action=read&id=<%= vo.getTitle() %>'><%= vo.getTitle() %></a> --%>
<section id="butright">	
<button class="good" onclick='display();'>작성하기</button>
<button class="good" onclick='noplay();'>작성 취소</button>
</section>

<div id="write" style="display:none">
<form method="post" action="http://70.12.115.178:8000/springnews/newsmain2">
	<input type="hidden" name="action" value="insert">
	작성자  <input type="text" name="writer" placeholder="작성자명을 입력해주세요" width="300px" class="box"><br><br>
	제  목  <input type="text" name="title" placeholder="제목을 입력해주세요" width="300px" class="box"><br>
	내  용<br><textarea rows="7" cols="40" placeholder="내용을 입력해주세요" name="content" class="box"></textarea><br>
	<input type="submit" value="저장" class="good">
	<input type="reset" value="재작성" class="good">
	<input type="button" value="취소" onclick="window.location='http://70.12.115.178:8000/springnews/newsmain'" class="good">
</form>
</div>

<!-- <div id="sorry" style="display:none">
<form method="post" action="/mvc/news">
	<input type="hidden" name="action" value="update">
	<input id="mname" type="text" name="writer" placeholder="작성자명을 입력해주세요"><br>
	<input id="mtitle" type="text" name="title" placeholder="제목을 입력해주세요"><br>
	<textarea id="mcontent" rows="7" cols="40" placeholder="내용을 입력해주세요" name="content"></textarea><br>
	<input type="submit" value="수정">
	<input type="reset" value="재작성">
	<input id="del" type="button" value="삭제" onclick="window.location='/mvc/news?action=delete&id='">
</form>
</div> -->
<div id="howcan" style="display:none">
<form method="post" action="http://70.12.115.178:8000/springnews/newsmain2">
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="id" value="${come.id}">
	작성자  <input id="mname" type="text" name="writer" placeholder="작성자명을 입력해주세요" value="${come.writer}" width="300px"><br><br>
	제  목  <input id="mtitle" type="text" name="title" placeholder="제목을 입력해주세요" value="${come.title }" width="300px"><br>
	내  용<br><textarea id="mcontent" rows="7" cols="40" placeholder="내용을 입력해주세요" name="content">${come.content }</textarea><br><br>
	<input type="submit" value="수정" class="good">
	<input id="del" type="button" value="삭제" onclick="window.location='http://70.12.115.178:8000/springnews/newsmain?action=delete&id=${come.id }'">
	<input type="button" value="목록으로" onclick="window.location='http://70.12.115.178:8000/springnews/newsmain'" class="good">
</form>
</div>

<script>
 function display() {
	 document.getElementById("write").style.display='block';
	 /* document.getElementById("sorry").style.display='none'; */
	 document.getElementById("howcan").style.display='none';
 }
 function noplay() {
	 document.getElementById("write").style.display='none';
 }
 
 window.onload = function() {
	 var action = "<%= request.getParameter("action")%>"
	 if(action=="read"){
		 document.getElementById("howcan").style.display="block";
		 document.getElementById("write").style.display="none";
	 } else {
		 document.getElementById("howcan").style.display="none";
	 }
 }
 
/*  function change(cn , p) {
	var doms = document.getElementsByClassName(cn)
	document.getElementById("write").style.display="none";
	document.getElementById("sorry").style.display='block';
	document.getElementById("mname").value=doms[2].textContent;
	document.getElementById("mtitle").value=doms[1].textContent;
	document.getElementById("mcontent").value=p;
 } */
 
 
</script>
</body>
</html>