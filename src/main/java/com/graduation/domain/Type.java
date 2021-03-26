package com.graduation.domain;

public class Type {

    private String songType;
    
    private Integer num;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Type [songType=" + songType + ", num=" + num + "]";
	}
    
}
