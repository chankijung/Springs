<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
	<div class="wrap">
		id:${info.id }<br>
		pw:${info.pw }<br>
		addr:${info.addr }<br>
	</div>
	<%@ include file="../default/footer.jsp" %>

</body>
</html>