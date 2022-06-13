package com.care.root.board.service;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public String getMessage(String msg,String url);
	public String IMAGE_REPO="c:/spring/image_repo";
	public String saveFile(MultipartFile file);
	public void deleteImage(String parameter);
}
