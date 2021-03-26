package com.graduation.domain;

import java.util.Date;

public class Song {

    private Integer songId;

    private String songName;

    private String songAuthor;
    
	private Date songDate;
    
    private String songPic;
    
    private String songType;
    
    private String songTime;
    
    private Integer songLikeNum;
    
    private String songSong;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}
    
    public String getSongAuthor() {
		return songAuthor;
	}

	public void setSongAuthor(String songAuthor) {
		this.songAuthor = songAuthor;
	}
	
	public Date getSongDate() {
		return songDate;
	}

	public void setSongDate(Date songDate) {
		this.songDate = songDate;
	}

	public String getSongPic() {
		return songPic;
	}

	public void setSongPic(String songPic) {
		this.songPic = songPic;
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	public String getSongTime() {
		return songTime;
	}

	public void setSongTime(String songTime) {
		this.songTime = songTime;
	}

	public Integer getSongLikeNum() {
		return songLikeNum;
	}

	public void setSongLikeNum(Integer songLikeNum) {
		this.songLikeNum = songLikeNum;
	}

	public String getSongSong() {
		return songSong;
	}

	public void setSongSong(String songSong) {
		this.songSong = songSong;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", songAuthor=" + songAuthor + ", songDate="
				+ songDate + ", songPic=" + songPic + ", songType=" + songType + ", songTime=" + songTime
				+ ", songLikeNum=" + songLikeNum + ", songSong=" + songSong + "]";
	}
    
}
