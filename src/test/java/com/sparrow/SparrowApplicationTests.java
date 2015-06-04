package com.sparrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sparrow.app.Application;
import com.sparrow.util.GsonSingleton;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SparrowApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(0);
	}
	
	/**
	 * 
	 * @param object
	 */
	public void print(Object object ) {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println( GsonSingleton.getGsonInstance().toJson(object));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	

}
