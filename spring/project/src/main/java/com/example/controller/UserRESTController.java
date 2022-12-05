package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDAO;
import com.example.domain.MissionVO;
import com.example.domain.UserInfoVO;
import com.example.domain.UserStatusVO;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {
	@Autowired
	UserDAO dao;
	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder encoder;

	String topdayid;
	String topweekid;
	//유저검색(userStatus)
	@RequestMapping("/userReadSt/{user_id}")
	public UserStatusVO userRead(@PathVariable String user_id){
		return dao.userRead(user_id);
	}

	//유저 검색(userInfo)
	@RequestMapping("/userRead/{user_Id}")
	public UserInfoVO read(@PathVariable String user_Id){
		return dao.userLogin(user_Id);
	}
	//유저 리스트
	@RequestMapping("/userStatus")
	public List<UserStatusVO> list(){
		return dao.userStatusList();
	}
	//유저 리스트(웹)
	@RequestMapping("/userStatusWeb")
	public HashMap<String,Object> userStatusListWeb(String search, int page, int num){
		System.out.println(">>>>>>>>>"+page+num);
		HashMap<String,Object> map = new HashMap<>();
		map.put("userList", dao.userStatusListWeb(search, page, num));
		map.put("total", dao.userTotal(search));
		return map;
	}
	@RequestMapping("/userBlackListWeb")
	public HashMap<String,Object> userBlackListWeb(String search, int page, int num){
		HashMap<String,Object> map = new HashMap<>();
		map.put("BlackList", dao.userBlackListWeb(search, page, num));
		map.put("blackTotal", dao.blackUserTotal(search));
		return map;
	}
	//유저 등록
	@RequestMapping(value = "/userRegister",method=RequestMethod.POST)
	public void userRegister(@RequestBody UserStatusVO userStatusVo){
		userStatusVo.setPassword(encoder.encode(userStatusVo.getPassword()));
		userService.userRegister(userStatusVo);
	}
	//로그인
	@RequestMapping(value = "/userLogin",method=RequestMethod.POST)
	public int userLogin(@RequestBody UserInfoVO userInfoVo){
		int result = 0;
		UserInfoVO loginVo = dao.userLogin(userInfoVo.getId());
		//System.out.println(loginVo.toString());
		if(loginVo.getId() != null){
			if(encoder.matches(userInfoVo.getPassword(),loginVo.getPassword() ) ){
				result = 1;
			}else{
				result = 2;
			}
		}		
		return result;
	}
	//중복체크 (0=정상 1중복 id)
	@RequestMapping("/userDuplicationId/{str}")
	public int duplicationId(@PathVariable String str){
		return dao.userIdDuplication(str);
	}
	//중복체크 (0=정상 1중복 id)
	@RequestMapping("/userDuplicationNickname/{str}")
	public int duplicationNickname(@PathVariable String str){
		return dao.usernickNameDuplication(str);
	}

	//아이디 찾기
	@RequestMapping("/userSearchId")
	public String serchId(String name, String tel){
		return dao.searchUserId(name, tel);
	}
	//비밀번호 변경
	@RequestMapping(value = "/updatepassword",method=RequestMethod.POST)
	public void updatePassword(@RequestBody UserInfoVO userInfovo){
		userInfovo.setPassword(encoder.encode(userInfovo.getPassword()));
		dao.updatePassword(userInfovo);
	}
	//유저정보 변경
	@RequestMapping(value = "/userupdate",method=RequestMethod.POST)
	public void updateUserstatus(@RequestBody UserStatusVO userStatusvo){
		dao.updateUserstatus(userStatusvo);
	}
	//회원 탈퇴
	@RequestMapping(value = "/userdelupdate",method=RequestMethod.POST)
	public void userdelupdate(@RequestBody UserStatusVO userStatusvo){
		userService.userDelUpdate(userStatusvo);
	}
	//일일최고포인트획득유저
	@Scheduled(cron = "0 0/3 * * * ?")
	public void dtpointScheduled(){
		HashMap<String, Object> map = dao.dayTopuser();
		topdayid =  (String)map.get("user_point_id");
		System.out.println(topdayid);
	}
	@RequestMapping("/dayuser")
	public UserStatusVO dayuser(){
		return dao.userRead(topdayid);
	}
	//주간최고포인트획득유저
	@Scheduled(cron = "0 0/3 * * * ?")
	public void wtpointScheduled(){
		HashMap<String, Object> map = dao.weekTopuser();
		topweekid =  (String)map.get("user_point_id");
		System.out.println(topweekid);
	}
	@RequestMapping("/weekuser")
	public UserStatusVO weekuser(){
		return dao.userRead(topweekid);
	}
	//유저 탈퇴 처리(관리자)
	@RequestMapping(value="/adminUserDel/{user_id}", method=RequestMethod.POST)
	public void userDelWeb(@PathVariable String user_id){
		dao.userDelWeb(user_id);
	}
	
	//유저 블랙 처리(관리자)
	@RequestMapping(value="/adminUserBlack/{user_id}", method=RequestMethod.POST)
	public void userBlackWeb(@PathVariable String user_id){
		dao.userBlackWeb(user_id);
	}
	//캐릭터 선택
	@RequestMapping(value = "/usercharsort",method=RequestMethod.POST)
	public void usercharsort(@RequestBody UserStatusVO userStatusvo){
		dao.userCharsort(userStatusvo);
	}
}
