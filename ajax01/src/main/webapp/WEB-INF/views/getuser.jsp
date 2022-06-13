<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getUsers(){
		$.ajax({
			url: "users", type :"get" dataType:"json",
			success:function(list){
			//	$("#users").text(list)}
			console.log(list)
			let str="";
			//str += "<b>이름 : "+list[0].name+"</b><br>";
		//	str += "<b>나이 : "+list[0].age+"</b><hr>";
			//str += "<b>이름 : "+list[1].name+"</b><br>";
			//str += "<b>나이 : "+list[1].age+"</b><hr>";
			for(let i =0; i<list.length;i++){
				str +="<b>이름 : "+list[i].name+"</b><br>";
				str +="<b>나이 : "+list[i].age+"</b><br>";
			}
			//$("#users").html(str)
			$("#users").append(str)
		})
	}
function userInfo(){
	$.ajax({
		url: "user?id="+$("#id").val(), type :"get" dataType:"json",
		success:function(list){
			let str=""
				str +="<b>이름 : "+list[i].name+"</b><br>";
				str +="<b>나이 : "+list[i].age+"</b><br>";
				$("#users").html(str)
		}
	})
	
}
</script>
</head>
<body>
	<div id="users"></div><hr>
	<button onclick="getUsers()">사용자목록보기 </button>
	<hr>
	<input type="text" id="id"><br>
	<button onclick="userInfo()">개인정보</button>
	
</body>
</html>