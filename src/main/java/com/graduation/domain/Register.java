package com.graduation.domain;

public class Register {

	private String email;
	private String code;
	private String password;
	private String reemail;
	private String recode;
	public String getRecode() {
		return recode;
	}
	public void setRecode(String recode) {
		this.recode = recode;
	}
	public String getReemail() {
		return reemail;
	}
	public void setReemail(String reemail) {
		this.reemail = reemail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", code=" + code + ", password=" + password + ", reemail=" + reemail
				+ ", recode=" + recode + "]";
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
