package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.CharacterVO;

public interface CharacterDAO {
	public List<CharacterVO> list();  //캐릭터 리스트
	public CharacterVO read(String character_grade); //캐릭터를 grade로 리드
	public void insert(CharacterVO vo); //캐릭터 업로드
	public void update(CharacterVO vo); //캐릭터 수정
	public void delete(String character_code); //삭제
	public HashMap<String, Object> usercharRead(String user_id);
	public List<CharacterVO> listg1();  //캐릭터 리스트 1LV
}
