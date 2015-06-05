//package com.sparrow.service.impl;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sparrow.SparrowApplicationTests;
//import com.sparrow.service.iface.IArticleService;
//import com.sparrow.vo.ArticleVo;
//
///**
// * @author       Jay
// * @time         2015年5月21日
// */
//public class ArticleServiceImplTest extends SparrowApplicationTests {
//	
//	@Autowired
//	IArticleService articleService;
//	
//	@Ignore
//	@Test
//	public void testSaveArticle() {
//		for(int i=0;i<20;i++){
//			ArticleVo vo = new ArticleVo("你个二货" + i, "hi 大家好 " + i ,"hi 大家好 我是超人" + i);
//			articleService.saveArticle(vo);
//		}
//	}
//	
//	@Test
//	public void testFindArticleByArticleId() {
//		ArticleVo articleVo = articleService.findArticleByArticleId("55652f5dbea26b734f3e21c1");
//		print(articleVo);
//	}
//
//	@Test
//	public void testFindAritcleBySortWithDate() {
//		List<ArticleVo> list = articleService.findAritcleBySortWithDate(new Date());
//		print(list);
//	}
//	
//	@Test
//	public void testFindAritcleByPagination() {
//		//List<ArticleVo> list = articleService.findAritcleByPagination(2,3);
//		//print(list);
//	}
//	
//	@Test
//	public void testDeleteArticleByArticleId() {
//		 articleService.deleteArticleByArticleId("55655aaebea2156be2944ea3");
//	}
//}
