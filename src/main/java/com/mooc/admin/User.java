package com.mooc.admin;

public class User {
	private String userName;
	private String userPwd;
	private String userTel;
	private String userEmail;
	public User() {
		// TODO 自动生成的构造函数存根
	}
	public User(String userName, String userPwd, String userTel, String userEmail) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPwd=" + userPwd + ", userTel=" + userTel + ", userEmail="
				+ userEmail + "]";
	}
	
}
