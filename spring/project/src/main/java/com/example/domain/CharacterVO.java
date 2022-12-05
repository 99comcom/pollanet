package com.example.domain;

public class CharacterVO {
	private int character_code;
	private String character_name;
	private String character_image;
	private String character_grade;
	private String character_sort;
	
	public String getCharacter_sort() {
		return character_sort;
	}
	public void setCharacter_sort(String character_sort) {
		this.character_sort = character_sort;
	}
	public int getCharacter_code() {
		return character_code;
	}
	public void setCharacter_code(int character_code) {
		this.character_code = character_code;
	}
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}
	public String getCharacter_image() {
		return character_image;
	}
	public void setCharacter_image(String character_image) {
		this.character_image = character_image;
	}
	public String getCharacter_grade() {
		return character_grade;
	}
	public void setCharacter_grade(String character_grade) {
		this.character_grade = character_grade;
	}
	@Override
	public String toString() {
		return "CharacterVO [character_code=" + character_code + ", character_name=" + character_name
				+ ", character_image=" + character_image + ", character_grade=" + character_grade + "]";
	}
	
	
	
}
