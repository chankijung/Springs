package com.care.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
   @GetMapping(value="rest",produces = "application/json; charset=utf-8")
   public String get() {
      return "{\"execute\" : \"get 데이터 요청할때 사용\"}";
   }
   @PostMapping(value="rest",produces = "application/json; charset=utf-8")
   public String post() {
      return "{\"execute\" : \"post 데이터 추가\"}";
   }
   @PutMapping(value="rest",produces = "application/json; charset=utf-8")
   public String put() {
      return "{\"execute\" : \"put 데이터 수정\"}";
   }
   @DeleteMapping(value="rest",produces = "application/json; charset=utf-8")
   public String delete() {
      return "{\"execute\" : \"del 데이터 삭제\"}";
   }
   
   static int cnt=0;
   static Map<String, InfoDTO> DBMap = 
		   new HashMap<String, InfoDTO>();
   @GetMapping(value="users", 
		   produces="application/json; charset=utf-8")
   public List<InfoDTO> users(){
	   ArrayList<InfoDTO> arr=new ArrayList<InfoDTO>();
	   for(int i = cnt; i<cnt+10; i++) {
		   InfoDTO info = new InfoDTO();
		   info.setName("홍길동"+i);
		   info.setAge(10+i);
		   arr.add(info);
		   DBMap.put("홍길동"+i, info);
	   }
	   cnt +=10;
	   return arr;
   }
}