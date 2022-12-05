package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.MissionUserDAO;
import com.example.domain.MissionUserVO;
import com.example.service.MissionService;


@RestController
@RequestMapping("/api/umission")
public class MissionUserRESTController {
	@Autowired
	MissionUserDAO dao;
	
	@Autowired
	MissionService service;
	
	@RequestMapping("/list")
	public List<MissionUserVO> list(String um_keyword, int um_start, int um_number){
		return dao.list(um_keyword, um_start, um_number);
		
	}

	//유저 미션 등록(이미지)
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@RequestParam(value = "mission_code")String mission_code,
			@RequestParam(value = "um_user_id")String um_user_id,
			@RequestParam(value = "um_content")String um_content,
			@RequestParam(value = "um_title")String um_title,
			@RequestParam(value = "um_get_point")String um_get_point,
			@RequestParam(value = "um_image", required = true)MultipartFile um_image
			) throws Exception  {
		MissionUserVO vo = new MissionUserVO();
		//System.out.println(um_image);

		String path="c:/upload/project/mission/";
		String name=um_image.getOriginalFilename();
		File newFile=new File(path+name);
		if(!newFile.exists()){
			um_image.transferTo(newFile);
		}
		vo.setUm_image("/project/mission/"+name);
		vo.setMission_code(Integer.parseInt(mission_code));
		vo.setUm_user_id(um_user_id);
		vo.setUm_content(um_content);
		vo.setUm_title(um_title);
		vo.setUm_get_point(Integer.parseInt(um_get_point) );
		
	vo.toString();
	service.insert(vo);
}
	@RequestMapping("/read/{user_mission_code}")
	public MissionUserVO read(@PathVariable String user_mission_code){
		return dao.read(user_mission_code);
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@RequestBody MissionUserVO vo,
			MultipartHttpServletRequest multi) throws Exception  {
	if(multi.getFile("um_image")!=null){
		MultipartFile um_image=multi.getFile("um_image");
		String path="c:/upload/project/mission";
		String name=um_image.getOriginalFilename();
		File newFile=new File(path+name);
		if(!newFile.exists()){
			um_image.transferTo(newFile);
		}
		vo.setUm_image("/project/mission/"+name);
	}

	dao.update(vo);
	}
	@RequestMapping(value="/delete/{user_mission_code}",method=RequestMethod.POST)
	public void delete(@RequestBody String user_mission_code){
		dao.delete(user_mission_code);
	}
	@RequestMapping("/userMissionList/{um_user_id}")
	public List<MissionUserVO> userMissionList(@PathVariable String um_user_id, int um_start, int um_number){
		return dao.userMissionList(um_user_id, um_start,um_number);
		
	}
	
}

