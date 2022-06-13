<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function getF(){
   $.ajax({
      url : "rest", type : "get", dataType : "json",
      success : function(data){
         $("#label").text(data.execute)
      }
   })
}
function postF(){
   $.ajax({
      url : "rest", type : "post", dataType : "json",
      success : function(data){
         $("#label").text(data.execute)
      }
   })
}
function putF(){
   $.ajax({
      url : "rest", type : "put", dataType : "json",
      success : function(data){
         $("#label").text(data.execute)
      }
   })
}
function deleteF(){
   $.ajax({
      url : "rest", type : "delete", dataType : "json",
      success : function(data){
         $("#label").text(data.execute)
      }
   })
}
</script>
</head>
<body>
   <label id="label"></label><hr>
   <button onclick="getF()">get</button>
   <button onclick="postF()">post</button>
   <button onclick="putF()">put</button>
   <button onclick="deleteF()">delete</button>
</body>
</html>









