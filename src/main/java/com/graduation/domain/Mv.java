package com.graduation.domain;

import java.util.Date;

public class Mv {

	private Integer mvId;

    private String mvName;

    private String mvAuthor;
    
	private Date mvDate;
    
    private String mvPic;
    
    private String mvType;
    
    private String mvMv;
    
    private String mvInfo;

	public Mv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMvId() {
		return mvId;
	}

	public void setMvId(Integer mvId) {
		this.mvId = mvId;
	}

	public String getMvName() {
		return mvName;
	}

	public void setMvName(String mvName) {
		this.mvName = mvName;
	}

	public String getMvAuthor() {
		return mvAuthor;
	}

	public void setMvAuthor(String mvAuthor) {
		this.mvAuthor = mvAuthor;
	}

	public Date getMvDate() {
		return mvDate;
	}

	public void setMvDate(Date mvDate) {
		this.mvDate = mvDate;
	}

	public String getMvPic() {
		return mvPic;
	}

	public void setMvPic(String mvPic) {
		this.mvPic = mvPic;
	}

	public String getMvType() {
		return mvType;
	}

	public void setMvType(String mvType) {
		this.mvType = mvType;
	}

	public String getMvMv() {
		return mvMv;
	}

	public void setMvMv(String mvMv) {
		this.mvMv = mvMv;
	}

	public String getMvInfo() {
		return mvInfo;
	}

	public void setMvInfo(String mvInfo) {
		this.mvInfo = mvInfo;
	}

	@Override
	public String toString() {
		return "Mv [mvId=" + mvId + ", mvName=" + mvName + ", mvAuthor=" + mvAuthor + ", mvDate=" + mvDate + ", mvPic="
				+ mvPic + ", mvType=" + mvType + ", mvMv=" + mvMv + ", mvInfo=" + mvInfo + "]";
	}
    
}
