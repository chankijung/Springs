package com.care.root.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;
	
	public void boardAllList(Model model, int num){
		
		int pageLetter = 3;
		int allCount = mapper.selectBoardCount();
		int repeat = allCount /pageLetter;
		if(allCount% pageLetter !=0) {
			repeat +=1;
		}
		int end = num * pageLetter;
		int start = end+1 -pageLetter;
		model.addAttribute("repeat", repeat);
		model.addAttribute(
			"boardList", mapper.boardAllList(start, end) );
	}
	public String writeSave(MultipartHttpServletRequest mul,
							HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		dto.setId(mul.getParameter("id"));
		
		MultipartFile file = mul.getFile("image_file_name");
		if(file.getSize() != 0) {
			dto.setImageFileName(bfs.saveFile(file)); //새 이미지 가져오기
			bfs.deleteImage(mul.getParameter("originFileName"));
		}else {
			dto.setImageFileName("nan");
		}
		int result = 0;
		result = mapper.writeSave(dto);
		String msg=null, url=null;
		if( result == 1) {
			msg = "새글이 추가되었습니다";
			url = request.getContextPath()+"/board/boardAllList";
		}else {
			msg = "문제가 발생하였습니다";
			url = request.getContextPath()+"/board/writeForm";
		}
		return bfs.getMessage( msg, url);
	}
	@Override
	public void contentView(int writeNo, Model model) {
		upHit(writeNo);
		model.addAttribute("dto", mapper.contentView(writeNo));
		
	}
	
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}
	@Override
	public String modify(MultipartHttpServletRequest mul, HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setWriteNo(Integer.parseInt(mul.getParameter("writeNo")));
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		MultipartFile file= mul.getFile("imageFileName");
		if(file.getSize() !=0) {
			dto.setImageFileName(bfs.saveFile(file));
		}else {
			dto.setImageFileName(
					mul.getParameter("originFileName"));
		}
		int result= 0;
		
		try {
			result=mapper.modify(dto); //database에 접근하는 코드들이 오류가 뜨면 try catch로 묶어보자
		} catch (Exception e) {
			e.printStackTrace();
		}
		String msg, url;
		if(result==1) {
			msg="성공적으로 수정됐습니다";
			
			url= request.getContextPath()+"/"+"/board/boardAllList";
		}else {
			msg="수정실패!!";
			url= request.getContextPath()+"/"+"/board/modify_form?writeNo="+dto.getWriteNo();
		}
		return bfs.getMessage(msg, url);
	}
	@Override
	public String delete(int writeNo, String imageFileName, HttpServletRequest request) {
		
		int result=mapper.delete(writeNo);
		String msg, url;
		if(result==1) {
			bfs.deleteImage(imageFileName);
			
			msg="삭제됐습니다";
			url= request.getContextPath()+"/"+"/board/boardAllList";
		}else {
			msg="삭제실패!!";
			url= request.getContextPath()+"/"+"/board/contentView?writeNo="+writeNo;
		}
		return bfs.getMessage(msg, url);
	}
	@Override
	public void addReply(BoardRepDTO dto) {
		mapper.addReply(dto);
	}
	@Override
	public List<BoardRepDTO> getRepList(int write_group) {

		return mapper.getRepList(write_group);
	}
	
	
}






















