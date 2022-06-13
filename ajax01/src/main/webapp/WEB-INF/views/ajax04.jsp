<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function test(){
   let n = document.getElementById('name').value;
   let a = $("#age").val();
   let addr=$("#addr").val();
   let form = {'name':n, 'age':a, addr: addr}
   $.ajax({
      url : 'ajax_result03', type:'post',
      data : JSON.stringify( form ), //서버로 보낼 데이터
      //보내는 데이터의 타입 지정
      contentType : "application/json; charset=utf-8", 
      dataType : 'json', //서버의 리턴 타입 지정
      success : function( result ){
         $("#label").text( result.name +','+ result.age+','+result.addr)
         console.log( result )
      },
      error : function(){ alert('문제발생'); }
   })
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="name"><br>
	<input type="text" id="age"><br>
	<input type="text" id="addr">
	<input type="button" onclick="test()">
	<hr>
	결과: <label id="label"></label>
	
</body>
</html>