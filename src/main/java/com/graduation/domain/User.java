package com.graduation.domain;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;
    
    private String userEmail;
    
    private String userPicHead;

    public String getUserPicHead() {
		return userPicHead;
	}

	public void setUserPicHead(String userPicHead) {
		this.userPicHead = userPicHead;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userPicHead=" + userPicHead + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}