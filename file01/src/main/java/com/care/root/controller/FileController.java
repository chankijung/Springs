package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.service.FileService;

@Controller
public class FileController {
//	public FileController(HttpSession session,
//						HttpServletRequest request) {
//		session.setAttribute("contextPath", request.getContextPath());
//	}
	@Autowired FileService fs;
	@GetMapping("/form")
	public String form(HttpSession session,
			HttpServletRequest request) {
		session.setAttribute("contextPath", request.getContextPath());
	
		return "uploadForm";
	}
	
	@PostMapping("/upload")
	public String upload(MultipartHttpServletRequest mul) {
		//멀티파트는 멀티파트http서블릿리퀘스트로 무조건 받아야함
//		System.out.println(mul.getParameter("id"));
//		System.out.println(mul.getParameter("name"));
////		System.out.println(mul.getParameter("file"));
//		
//		MultipartFile file = mul.getFile("file");
//		System.out.println(file.getOriginalFilename());
//		String path=
//				"C:/Users/mono9/OneDrive/문서/카카오톡 받은 파일/취업반 자료/file01 multipartresolver/file01/";
//		try {
//			File f= new File(file.getOriginalFilename());
//			file.transferTo(f);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		fs.fileProcess(mul);
		
		
		
		return "redirect:form";
	}
	
	@GetMapping("views")
	public String views(Model model) {
		fs.getImages(model);
		return "result";
	}
	
	@GetMapping("download")
	public void download(@RequestParam String file,
						HttpServletResponse response) throws Exception{
		response.addHeader("Content-disposition",//다운로드 형식으로 보내겠습니다
						"attachment; filename="+file); //attachment(붙이겟다)
		File f = new File(FileService.IMAGE_REPO+file);
		FileInputStream in = new FileInputStream(f);
		
		FileCopyUtils.copy(in, response.getOutputStream());//왼쪽에 있는 값을 오른쪽으로 카피하겠다
		in.close();
	}
}
