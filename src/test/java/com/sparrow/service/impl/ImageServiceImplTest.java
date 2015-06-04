package com.sparrow.service.impl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sparrow.SparrowApplicationTests;
import com.sparrow.entity.mongo.Image;
import com.sparrow.service.iface.IImageService;

/**
 * description
 * @author 		Jay
 * @time		2015年6月4日
 */
public class ImageServiceImplTest extends SparrowApplicationTests{

	@Autowired
	IImageService service;
	
	@Test
	public void testSaveImage() {
		Image image = new Image();
		image.setTitle("title");
		image.setSummary("sum");
		image.setPath("123123");
		service.saveImage(image);
	}

	@Test
	public void testFindImageByPagination() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindImageById() {
		print(service.findImageById("556fb96c7da2e222db101a9a"));
	}

	@Ignore
	@Test
	public void testDeleteImageById() {
		service.deleteImageById("556fb96c7da2e222db101a9a");
	}

}

