package com.example.demo.domain;

public enum GenreEnum {
	SCIENCE_FICTION("1"),
	SATIR("2"),
	DRAMA("3"),
	ACTION_AND_ADVENTURE("4"),
	ROMANCE("5"),
	MYSTERY("6"),
	HORROR("7"),
	SELFHELP("8");
	
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	private GenreEnum(String code) {this.code = code;}
}