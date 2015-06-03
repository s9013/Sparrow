package com.sparrow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sparrow.entity.mongo.User;
import com.sparrow.repository.UserRepository;
import com.sparrow.service.iface.IUserService;
import com.sparrow.vo.UserVo;

/**
 * 用户业务逻辑实现类
 * @author       Jay
 * @time         2015年5月21日
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String hello() {
		throw new IllegalArgumentException("异常测试");
//		User user = new User("Jay", "1234");
//		userRepository.save(user);
//		return "Hello Jay"; 
	}

	@Override
	public void addUser(UserVo userVo) {
		User user = new User(userVo.getUsername(), userVo.getPassword());
		userRepository.save(user);
	}

	@Override
	public void updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVo findUserByUserId(String userId) {
		User user = userRepository.findOne(userId);
		UserVo userVo;
		if(null == user){
			userVo = new UserVo();
		}else{
			userVo = new UserVo(user.getUsername(),user.getPassword());
		}
		return userVo;
	}

	@Override
	public UserVo findUserByUserName(String username) {
		User user = userRepository.findByUsername(username);
		UserVo userVo;
		if(null == user){
			userVo = new UserVo();
		}else{
			userVo = new UserVo(user.getUsername(),user.getPassword());
		}
		return userVo;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.delete(userId);
	}

	@Override
	public List<UserVo> findUsersOrder() {
		Query query=new Query();
		//query.addCriteria(Criteria.where("mobile").is(mobile));
		query.with(new Sort(Sort.Direction.DESC,"username"));
		List<User> list = mongoTemplate.find(query, User.class);
		//query.skip((page-1)*pageSize);
		//query.limit(pageSize);
		List<UserVo> userList = new ArrayList<UserVo>(); 
		for(User user : list){
			UserVo userVo = new UserVo();
			userVo.setUsername(user.getUsername());
			userList.add(userVo);
		}
		return userList;
	}



}
