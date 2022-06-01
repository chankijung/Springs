package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{

	@Autowired FileMapper fm;

	public void fileProcess(MultipartHttpServletRequest mul) {

		FileDTO dto = new FileDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		dto.setImgName(mul.getParameter("imgName"));

		MultipartFile file = mul.getFile("file");	
		if(file.getSize() != 0) {
			//file.isEmpty()==false) d{
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss-");
			//20220601113341-(img.jpg)
			String sysFileName = f.format(new Date());
			sysFileName += file.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO+sysFileName);
			System.out.println("파일 등록 완료");

			dto.setImgName(sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		fm.saveData(dto);
	}

	@Override
	public void getImages(Model model) {
		model.addAttribute("list", fm.getImages());
	}

}
