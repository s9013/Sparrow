package com.sparrow.vo;


/**
 * 用户vo
 * @author       Jay
 * @time         2015年5月21日
 */
public class UserVo{


	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 用户密码
	 */
	private String password;

	public UserVo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserVo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
