<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <c:set var="contextPath" value="${pageContext.request.contextPath }" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath }/upload" method="post"
				enctype="multipart/form-data">
				<!-- 파일업로드를 위해서는 멀티파트라는 enctype 써야함 -->
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="file" name="file"><br>
		<!-- 용량이 크면 무조건 post -->
		<input type="submit" value="업로드"><br>
	
	</form>
	<a href="views">파일보기</a>
</body>
</html>