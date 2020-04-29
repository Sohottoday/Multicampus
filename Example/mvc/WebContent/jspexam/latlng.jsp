<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
<c:choose>
	<c:when test="${ pageContext.request.method == 'GET' }">
	<h1>주소를 입력하시오!!</h1>
	<hr>
	<form method="post" action="/mvc/jspexam/latlng.jsp">
	<input type="text" name="textin">
	<input type="submit" value="검색">
	</form>
	</c:when>
	
	<c:otherwise>
	<c:catch var="whynot">
	
		<c:import var="loc" url='https://maps.googleapis.com/maps/api/geocode/xml?address=${URLEncoder.encode(param.textin, "UTF-8")}&language=ko&key=AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c'></c:import>
		<x:parse varDom="gps" xml="${loc}"></x:parse>
		<x:if select="$gps//status ='OK'">
			<h2>주소 : ${param.textin}</h2>
			<h2>위도 : <x:out select="$gps/GeocodeResponse/result/geometry/location/lat" /></h2>
			<h2>경도 : <x:out select="$gps/GeocodeResponse/result/geometry/location/lng" /></h2>
			<a href="/mvc/jspexam/latlng.jsp">입력 화면으로</a>
		</x:if>
		<x:if select="$gps//status !='OK'">
			<h2>잘못된 주소입니다.</h2>
			<a href="/mvc/jspexam/latlng.jsp">입력 화면으로</a>
		</x:if>
	</c:catch>
	<c:if test="${ !empty whynot }">
	<h2>주소를 입력하십시오.</h2>
	<a href="/mvc/jspexam/latlng.jsp">입력 화면으로</a> 
	</c:if>
	</c:otherwise>
</c:choose>

</body>
</html>