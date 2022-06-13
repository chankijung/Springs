package com.care.root.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	String IMAGE_REPO = "c:/spring/image_repo/";
	public void fileProcess(MultipartHttpServletRequest mul);
	public void getImages(Model model);
	public void fileProcess02(MultipartHttpServletRequest mul);
	

}
