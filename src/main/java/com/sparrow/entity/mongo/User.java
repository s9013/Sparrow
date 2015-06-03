package com.sparrow.entity.mongo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author       Jay
 * @time         2015年5月21日
 */
@Document(collection="User")
public class User implements Serializable{

	private static final long serialVersionUID = -1330735258248742982L;
	
	/**
	 * 用户id
	 */
	@Id
	private String userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
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
