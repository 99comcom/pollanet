package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.CharacterVO;

public interface CharacterDAO {
	public List<CharacterVO> list();  //ĳ���� ����Ʈ
	public CharacterVO read(String character_grade); //ĳ���͸� grade�� ����
	public void insert(CharacterVO vo); //ĳ���� ���ε�
	public void update(CharacterVO vo); //ĳ���� ����
	public void delete(String character_code); //����
	public HashMap<String, Object> usercharRead(String user_id);
	public List<CharacterVO> listg1();  //ĳ���� ����Ʈ 1LV
}
