<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function test(){
	var arr = {key : 값,}
	$.ajax({
		url : "ajax", type : "get:", 
		success : function(){
			console.log('연결 성공')
		},
		error : function(){
			alert('연결 실패')
		},
	})
	
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>ajax</h1>
</body>
</html>