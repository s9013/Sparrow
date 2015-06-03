package com.sparrow.service.iface;

import java.util.List;

import com.sparrow.vo.UserVo;

/**
 * 用户业务逻辑接口
 * @author       Jay
 * @time         2015年5月21日
 */
public interface IUserService {

	/**
	 * hello 测试
	 */
	public String hello();
	
	/**
	 * 添加用户
	 * @param userVo	用户对象	
	 */
	public void addUser(UserVo userVo);
	
	/**
	 * 更新用户
	 * @param user	User
	 */
	public void updateUser(UserVo userVo);
	
	/**
	 * 查找用户
	 * @param userId	用户id
	 */
	public UserVo findUserByUserId(String userId);
	
	/**
	 * 查找用户
	 * @param username	用户名
	 */
	public UserVo findUserByUserName(String username);
	
	/**
	 * 查找所用用户排序
	 * @param username	用户名
	 */
	public List<UserVo> findUsersOrder();
	
	/**
	 * 删除用户
	 * @param userId	用户id
	 */
	public void deleteUser(String userId);
	
}
