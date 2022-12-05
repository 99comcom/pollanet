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
	//�����˻�(userStatus)
	@RequestMapping("/userReadSt/{user_id}")
	public UserStatusVO userRead(@PathVariable String user_id){
		return dao.userRead(user_id);
	}

	//���� �˻�(userInfo)
	@RequestMapping("/userRead/{user_Id}")
	public UserInfoVO read(@PathVariable String user_Id){
		return dao.userLogin(user_Id);
	}
	//���� ����Ʈ
	@RequestMapping("/userStatus")
	public List<UserStatusVO> list(){
		return dao.userStatusList();
	}
	//���� ����Ʈ(��)
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
	//���� ���
	@RequestMapping(value = "/userRegister",method=RequestMethod.POST)
	public void userRegister(@RequestBody UserStatusVO userStatusVo){
		userStatusVo.setPassword(encoder.encode(userStatusVo.getPassword()));
		userService.userRegister(userStatusVo);
	}
	//�α���
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
	//�ߺ�üũ (0=���� 1�ߺ� id)
	@RequestMapping("/userDuplicationId/{str}")
	public int duplicationId(@PathVariable String str){
		return dao.userIdDuplication(str);
	}
	//�ߺ�üũ (0=���� 1�ߺ� id)
	@RequestMapping("/userDuplicationNickname/{str}")
	public int duplicationNickname(@PathVariable String str){
		return dao.usernickNameDuplication(str);
	}

	//���̵� ã��
	@RequestMapping("/userSearchId")
	public String serchId(String name, String tel){
		return dao.searchUserId(name, tel);
	}
	//��й�ȣ ����
	@RequestMapping(value = "/updatepassword",method=RequestMethod.POST)
	public void updatePassword(@RequestBody UserInfoVO userInfovo){
		userInfovo.setPassword(encoder.encode(userInfovo.getPassword()));
		dao.updatePassword(userInfovo);
	}
	//�������� ����
	@RequestMapping(value = "/userupdate",method=RequestMethod.POST)
	public void updateUserstatus(@RequestBody UserStatusVO userStatusvo){
		dao.updateUserstatus(userStatusvo);
	}
	//ȸ�� Ż��
	@RequestMapping(value = "/userdelupdate",method=RequestMethod.POST)
	public void userdelupdate(@RequestBody UserStatusVO userStatusvo){
		userService.userDelUpdate(userStatusvo);
	}
	//�����ְ�����Ʈȹ������
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
	//�ְ��ְ�����Ʈȹ������
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
	//���� Ż�� ó��(������)
	@RequestMapping(value="/adminUserDel/{user_id}", method=RequestMethod.POST)
	public void userDelWeb(@PathVariable String user_id){
		dao.userDelWeb(user_id);
	}
	
	//���� �� ó��(������)
	@RequestMapping(value="/adminUserBlack/{user_id}", method=RequestMethod.POST)
	public void userBlackWeb(@PathVariable String user_id){
		dao.userBlackWeb(user_id);
	}
	//ĳ���� ����
	@RequestMapping(value = "/usercharsort",method=RequestMethod.POST)
	public void usercharsort(@RequestBody UserStatusVO userStatusvo){
		dao.userCharsort(userStatusvo);
	}
}
