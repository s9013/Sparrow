//package com.sparrow.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.sparrow.app.Application;
//
///**
// * @author Jay
// * @time 2015年5月27日
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@SpringApplicationConfiguration(classes = Application.class)
////@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext-webmvc-config.xml"})
//public class ArticleControllerTest {
//
//	@Autowired
//	private WebApplicationContext wac;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setUp() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
//
//
//	@Test
//	public void testGetArtilces() {
//		try {
//			mockMvc.perform(get("/api/article/getArticles")).andExpect(status().isOk());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testGetArticleById() throws Exception {
//		ResultActions  r = mockMvc.perform(get("/api/article/getArticleById").param("id", "55655a86bea2a17ddba295ae"));//.andExpect(status().isOk());
//		System.out.println(r);
//	}
//
//}
