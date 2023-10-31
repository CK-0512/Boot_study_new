package com.jslhrd.expds.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jslhrd.expds.domain.PdsDTO;
import com.jslhrd.expds.service.PdsService;

@Controller
@RequestMapping("Pds")
public class PdsController {
	private Logger log = 
			LoggerFactory.getLogger(PdsController.class);

	@Autowired
	private PdsService service;
	
	@GetMapping("pds_list")
	public void pdsList() {
		log.info("Call : pds_list");
	}
	//등록 폼
	@GetMapping("pds_write")
	public void pdsWrite() {
		log.info("Call : pds_write");
	}
	
	//등록 처리
	@PostMapping("pds_write")
	public void pdsWritePro(MultipartHttpServletRequest request) {
		log.info("Call : pds_write_pro");
		PdsDTO dto = new PdsDTO();
		dto.setName(request.getParameter("name"));
		dto.setPass(request.getParameter("pass"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContents(request.getParameter("contents"));
		
		//파일저장경로
		String path=request.getServletContext().getRealPath("/upload/");
		MultipartFile mf = request.getFile("filename");
		String fileName = mf.getOriginalFilename();
		File file = new File(path+fileName);
		try {
			mf.transferTo(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setFilename(fileName);
		service.pdsWrite(dto);
		
		return "redirect:pds_list";
	}
	
	
}
