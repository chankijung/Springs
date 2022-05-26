<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
		${memberList.size() }
		<div class="wrap">
			<table class="table">
				<tr> <th>아이디</th> <th>비밀번호</th> <th>주소 </th>
				</tr>
				<c:forEach var="dto" items="${memberList }">
					<tr>
						<th>${dto.id }</th><th>${dto.pw }</th><th>${dto.addr }</th>
					</tr>
				</c:forEach>
			
			</table>
		
		</div>
	<%@ include file="../default/footer.jsp" %>

</body>
</html>