package com.graduation.domain;

import java.util.Date;

public class LikeSong {
	
    private Integer wid;
    
    private Integer userId;
    
    private Integer songId;

    private String songName;

    private String songAuthor;
    
	private Date songDate;
    
    private String songPic;
    
    private String songType;
    
    private String songSong;

	public LikeSong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getSongSong() {
		return songSong;
	}

	public void setSongSong(String songSong) {
		this.songSong = songSong;
	}

	@Override
	public String toString() {
		return "LikeSong [wid=" + wid + ", userId=" + userId + ", songId=" + songId + ", songName=" + songName
				+ ", songAuthor=" + songAuthor + ", songDate=" + songDate + ", songPic=" + songPic + ", songType="
				+ songType + ", songSong=" + songSong + "]";
	}
    

}
