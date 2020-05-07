<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, vo.TalkVO,vo.TalkCommentVO, dao.PagingControl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#listoneform {
	margin-top: 150px;
	padding-top: 50px;
	text-align: center;
	margin-left: 250px;
	margin-right: 80px;
	margin-bottom: 150px;
	width: 830px;
	background-color: #343a40;
}

#update_table {
	margin-bottom: 0px;
}

table-td {
	padding: 0px;
}

#commentform {
	text-align: center;
}

#columnview {
	text-align: center;
}

#comment_insert {
	margin-left: auto;
	margin-right: auto;
}

#board3 {
	height: 700px;
}

#comm_contents {
	vertical-align: middle;
	padding-top: 10px;
}
</style>
<!-- core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">

<!-- Custom fonts for this template -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css"">
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/grayscale.min.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>


<%@include file="./navbar.jsp"%>

</head>

<body class="masthead">
	<!-- 게시글 상세 보기 페이지 -->
	<div id="listoneform">
		<div class="listonediv" id="board1">
			<form method="post" action="/miniproject/talk/update" id="columnview"
				style="display: none; height: 500px">
				<input type="hidden" name="id" value="${column.id}">
				<table class="table table-dark " id="update_table">
					<tr>
						<th>작성자</th>
						<td><input id="columnwriter" style="width: 723px;"
							name="writer" placeholder="이름을 입력해주세요" value="${column.writer }"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input id="columntitle" style="width: 723px;"
							name="title" placeholder="제목을 입력해주세요" value="${column.title }"></td>
					<tr>
						<th>내용</th>
						<td><textarea id="columncontents" id="contents" rows="15"
								cols="100" name="content" placeholder="내용을 입력해주세요">${column.content }</textarea></td>
					</tr>
				</table>

				<input type="hidden" name="format" value="update"> <input
					type="submit" value="수정"
					onclick="location.href='/miniproject/talk/update?talkid=${column.id}'">
				<input type="button" value="삭제"
					onclick="location.href='/miniproject/talk/delete?talkid=${column.id}'">
				<input type="button" value="목록으로"
					onclick="location.href='/miniproject/talk'">
			</form>
			<br>
			<br>


			<!-- Reply Form {s} -->
			<div class="my-3 p-3 bg-white rounded shadow-sm"
				style="width: 750px; text-align: center; margin-left: 45px;">
				<div id="commentform">
					<h6 class="border-bottom pb-2 mb-0">Comment</h6>
					<div class="comment_insert">
						<textarea id="comm_contents" rows="3" cols="90"
							name="comm_content" placeholder="댓글을 입력해주세요"></textarea>
						<input type="hidden" name="format" value="insert"> <input
							type="submit" style="height: 75px;" value="저장"
							onclick="replybutton();">
					</div>
				</div>
			</div>

			<!--Reply List {s}  -->
			<div id="replylistform" class="my-3 p-3 bg-white rounded shadow-sm"
				style="padding-top: 10px; width: 750px; text-align: center; margin-left: 45px;">
				<h6 class="border-bottom pb-2 mb-0">Comment list</h6>
				<div id="replyList">

	<% List<TalkCommentVO> list = (List<TalkCommentVO>) request.getAttribute("list");
	if (list != null) {	
	for (TalkCommentVO vo : list) {	
	%>					
		<ul>
			<li>${vo.getWriter}</li>
			<li>${vo.getContent}</li>
			<li>${vo.getWritedate}</li>
		</ul>
	<%
	}
	}
	%>	
				</div>
			</div>


			<script>
				/* //글 상세보기 출력	 */
				window.onload = function() {
					var id =
			<%=request.getParameter("talkid")%>
				;
					if (id != null) {
						document.getElementById("columnview").style.display = 'block';
					}
				}

				/* 댓글 버튼 구현 , 서버로 전달 */

				function replybutton() {
					console.log("ajax로 댓글입력중");
					var replycontent = document.getElementById('comm_contents').value;
					console.log(replycontent);
					var xhr = new XMLHttpRequest();
					xhr.onload = function(event) {
						if (xhr.status == 200) {
							var str = xhr.responseText;
							var target = document.getElementById('replyList');
							target.innerHTML = str;
						}
					};
					xhr.open('POST', '/miniproject/comment/insert?content='
							+ replycontent, true);
					xhr.send();
				};
				/* 
				 댓글목록
				 function commentList(){
				 var replylist = document.getElementById('replyList').value;
				 console.log(commentlist_ajax);
				 var xhr = new XMLHttpRequest();
				 xhr.onload = function(event) {
				 if (xhr.status == 200) {
				 var str = xhr.responseText;
				 var target = document.getElementById('replyList');
				 target.innerHTML = str;
				 }
				 };
				 xhr.open('POST', '/miniproject/comment/list, true);
				 xhr.send();
				 };
				

				 //페이지 로딩시 댓글목록 출력하기.
				 $(document).ready(function(){
				 commentList(); 
				 });
				 */
			</script>
</body>
</html>