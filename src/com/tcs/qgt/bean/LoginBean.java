package com.tcs.qgt.bean;

public class LoginBean {

	private static String username;
	private static String password;
	private static String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		LoginBean.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		LoginBean.password = password;
	}
	public String getRole() {
		System.out.println( "get"+role);
		return role;
	}
	public void setRole(String role) {
		LoginBean.role = role;
		System.out.println("set"+role);
	}
	
	
}
