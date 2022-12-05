package com.example.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.GroupDAO;
import com.example.domain.GroupVO;
import com.example.service.GroupService;


@RestController
@RequestMapping("/api/group")
public class GroupRESTController {
	@Autowired
	GroupDAO dao;
	
	@Autowired
	GroupService service;
	
	@RequestMapping("/list")
	public List<GroupVO>list(String g_keyword){
		return dao.list(g_keyword);
		
	}
	@RequestMapping("/read/{group_code}")
	public GroupVO read(@PathVariable String group_code){
		return dao.read(group_code);
		
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void groupinsert(@RequestBody GroupVO vo){
//			,
//			MultipartHttpServletRequest multi) throws Exception  {
//	if(multi.getFile("")!=null){
//		MultipartFile g_image=multi.getFile("g_image");
//		String path="c:/upload/project/mission";
//		String name=g_image.getOriginalFilename();
//		File newFile=new File(path+name);
//		if(!newFile.exists()){
//			g_image.transferTo(newFile);
//		}
//		vo.setG_image("/project/group/"+name);
//	}
		service.groupinsert(vo);
}
	
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@RequestBody GroupVO vo,
			MultipartHttpServletRequest multi) throws Exception  {
	if(multi.getFile("")!=null){
		MultipartFile g_image=multi.getFile("g_image");
		String path="c:/upload/project/mission";
		String name=g_image.getOriginalFilename();
		File newFile=new File(path+name);
		if(!newFile.exists()){
			g_image.transferTo(newFile);
		}
		vo.setG_image("/project/group/"+name);
	}
	dao.update(vo);
}
	@RequestMapping(value="/delete/{group_code}",method=RequestMethod.POST)
	public void delete(@PathVariable int group_code){
		dao.delete(group_code);
		
	}
	
	
}
