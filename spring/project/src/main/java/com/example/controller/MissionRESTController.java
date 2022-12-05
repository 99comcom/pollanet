package com.example.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.MissionDAO;
import com.example.domain.MissionVO;
import com.example.service.MissionService;
import com.google.common.collect.Multiset.Entry;

@RestController
@RequestMapping("/api/mission")
public class MissionRESTController {
	@Autowired
	MissionDAO dao;
	
	@Autowired
	MissionService service;
	
	MissionVO mdvo;
	MissionVO mwvo;
	int dcode=0;
	int wcode=0;
	
	@RequestMapping("/list")
	public List<MissionVO> list(String m_keyword, int m_start, int m_number){
		return dao.list(m_keyword, m_start, m_number);
	}
	@RequestMapping("/listTotal")
	public HashMap<String, Object> listTotal(String m_keyword, int m_start, int m_number){
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", dao.list(m_keyword, m_start, m_number));
		map.put("total", dao.listTotal());
		return map;
	}
	@RequestMapping("/categorylist")
	public List<MissionVO> categorylist(String m_category, String m_sort,int m_start, int m_number){
		System.out.println(m_category);
		return dao.categorylist(m_category,m_sort, m_start, m_number);
	}
	
	@RequestMapping("/read/{mission_code}")
	public MissionVO reqd(@PathVariable int mission_code){
		return dao.read(mission_code);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@RequestBody MissionVO vo,MultipartHttpServletRequest multi) throws Exception  {
		
		if(multi.getFile("m_image")!=null){
			MultipartFile m_image=multi.getFile("m_image");
			String path="c:/upload/project/mission/";
			String name=m_image.getOriginalFilename();
			File newFile=new File(path+name);
			if(!newFile.exists()){m_image.transferTo(newFile);
			}
			vo.setM_image("/upload/project/mission"+name);
		}
		if(multi.getFile("mc_image")!=null){
			MultipartFile mc_image=multi.getFile("mc_image");
			String path="c:/upload/project/mission_info";
			String name=mc_image.getOriginalFilename();
			File newFile=new File(path+name);
			if(!newFile.exists()){
				mc_image.transferTo(newFile);
			}
			
			vo.setM_content_image("/upload/project/mission_info"+name);
		}
		
		dao.insert(vo);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@RequestBody MissionVO vo,MultipartHttpServletRequest multi) throws Exception  {
		
		if(multi.getFile("m_image")!=null){
			MultipartFile m_image=multi.getFile("m_image");
			String path="c:/upload/project/mission";
			String name=m_image.getOriginalFilename();
			File newFile=new File(path+name);
			if(!newFile.exists()){m_image.transferTo(newFile);
			}
			vo.setM_image("/upload/project/mission"+name);
		}
		if(multi.getFile("mc_image")!=null){
			MultipartFile mc_image=multi.getFile("mc_image");
			String path="c:/upload/project/mission_info";
			String name=mc_image.getOriginalFilename();
			File newFile=new File(path+name);
			if(!newFile.exists()){
				mc_image.transferTo(newFile);
			}
			
			vo.setM_content_image("/upload/project/mission_info"+name);
		}
		dao.update(vo);

	}
	
	@RequestMapping(value="/delete/{mission_code}",method=RequestMethod.POST)
	public void delete(@RequestBody int mission_code){
		dao.delete(mission_code);
	}
	
	//스케줄러
//	@Scheduled(cron = "0 0 1 * * *")
//	public void missionScheduled(){
//		System.out.println("미션초기화");
//	}
//	스케줄러(어제 많이 참여한 미션)
	@Scheduled(cron = "0 0/3 * * * ?")
	public void dmissionScheduled(){
		HashMap<String, Object> map = dao.topmission("d");
		dcode =  (Integer)map.get("mission_code");
		System.out.println(dcode);
	}
	@RequestMapping("/todayMission")
	public MissionVO todayMission(){
		//System.out.println(code);
		return dao.read(dcode);
	}
//	스케줄러(지난주 많이 참여한 미션)
		@Scheduled(cron = "0 0/3 * * * ?")
		public void wmissionScheduled(){
			HashMap<String, Object> map = dao.topwmission("w");
			wcode =  (Integer)map.get("mission_code");
			System.out.println(wcode);
		}
	@RequestMapping("/weekMission")
	public MissionVO weekMission(){
		return dao.read(wcode);
	}
	@RequestMapping("/bestMission")
	public MissionVO bestMission(){
		return dao.bestMission();
	}
	//클리어 했는지 확인
	@RequestMapping("/clearMission/{um_user_id}/{mission_code}")
	public int clearMission(@PathVariable String um_user_id, @PathVariable int mission_code){
		return dao.clearMission(um_user_id, mission_code);
	}
	//클리어 total
		@RequestMapping("/clearMissionTotal/{um_user_id}")
		public int clearMission(@PathVariable String um_user_id){
			return dao.clearMissionTotal(um_user_id);
		}
}
