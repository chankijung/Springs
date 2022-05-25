<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath }/css/test.css">
 --%><link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/test.css">

</head>
<body>index.jsp<br>
<h1 class="test"> css연습</h1>

<form action="result">
	<input type="text" name="id"><br>
	<input type="submit" value="전송">
	
</form>
<hr>
<img alt="" width="100px" src="/mvc04/resources/pepe.jpg">
<script type="text/javascript" src="/mvc04/resousrces/css/test.css"></script>
<script type="text/javascript" src="/mvc04/css/test.css"></script>
<button onclick="test()">클릭</button>
</body>
</html>








