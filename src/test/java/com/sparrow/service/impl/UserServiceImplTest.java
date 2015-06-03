//package com.sparrow.service.impl;
//
//import static org.junit.Assert.fail;
//
//import java.util.List;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sparrow.base.BaseTest;
//import com.sparrow.service.iface.IUserService;
//import com.sparrow.vo.UserVo;
//
///**
// * @author       Jay
// * @time         2015年5月21日
// */
//public class UserServiceImplTest extends BaseTest {
//	
//	@Autowired
//	IUserService userService;
//	
//	@Test
//	public void testHello() {
//		userService.hello();
//	}
//	
//	@Test
//	public void testAddUser() {
//		userService.addUser(new UserVo("test", "0000"));
//	}
//
//	@Ignore
//	@Test
//	public void testUpdateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindUserByUserId() {
//		UserVo userVo = userService.findUserByUserId("55652cd3bea2800a11b8dea6");
//		print(userVo);
//	}
//
//	@Test
//	public void testFindUserByUserName() {
//		UserVo userVo = userService.findUserByUserName("Jay");
//		print(userVo);
//	}
//
//	@Test
//	public void testDeleteUser() {
//		userService.deleteUser("555ec1aebea27aa9946842b7");
//	}
//	
//	@Test
//	public void testFindUsersOrder() {
//		List<UserVo> users = userService.findUsersOrder();
//		print(users);
//	}
//	
//}
