package com.example.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.CharacterDAO;
import com.example.domain.CharacterVO;


@RestController
@RequestMapping("/api/character")
public class CharacterRESTController {
	@Autowired
	CharacterDAO dao;
	
	//특정유저의 캐릭터
	@RequestMapping("/userchar/{user_id}")
	public HashMap<String, Object> userchar(@PathVariable String user_id){		
		return dao.usercharRead(user_id);
		
	}
	
	@RequestMapping("/list")
	public List<CharacterVO>list(){
		return dao.list();
	}
	
	@RequestMapping("/listG1")
	public List<CharacterVO>listg1(){
		return dao.listg1();
	}
	
	@RequestMapping("/read/{character_grade}")
	public CharacterVO read(@PathVariable String character_grade){		
		return dao.read(character_grade);
		
	}

	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(CharacterVO vo, MultipartHttpServletRequest multi)
	throws Exception{
		if(multi.getFile("file")!=null){
			MultipartFile file=multi.getFile("file");
			String path="c:/upload/photo";
			String fileName=file.getOriginalFilename();
			File newFile=new File(path+fileName);
			
			if(!newFile.exists())file.transferTo(newFile);
			vo.setCharacter_image("/upload/photo/"+fileName);
			
		}
		dao.insert(vo);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(CharacterVO vo, MultipartHttpServletRequest multi)
	throws Exception{
		if(multi.getFile("file")!=null){
			MultipartFile file=multi.getFile("file");
			String path="c:/upload/photo";
			String fileName=file.getOriginalFilename();
			File newFile=new File(path+fileName);
			
			if(!newFile.exists())file.transferTo(newFile);
			vo.setCharacter_image("/upload/photo/"+fileName);
			
		}
		dao.update(vo);
	}
	
	@RequestMapping(value="/delete/{character_code}", method=RequestMethod.POST)
	public void delete(@PathVariable String character_code){

		dao.delete(character_code);
	}
	
}
