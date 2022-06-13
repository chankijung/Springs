<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function test(){
	$.ajax({
		url : "ajax_result02", type : "get", 
		success : function(data){
			console.log('연결 성공')
			$("#cnt").text(data)
		},
		error : function(){
			alert('연결 실패')
		}
	})
	
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>ajax</h1>
	<h1>일</h1>
		<h1>일</h1>
		<h1>일</h1>
		<h1>일</h1>
		<h1>일</h1>
		<h1>일</h1>
		<button onclick="test()">클릭</button>
		<label id="cnt">0</label>
</body>
</html>





