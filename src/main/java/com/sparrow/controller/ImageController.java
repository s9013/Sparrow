package com.sparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sparrow.entity.mongo.Image;
import com.sparrow.service.iface.IFileService;
import com.sparrow.service.iface.IImageService;
import com.sparrow.vo.PaginationVo;

/**
 * Image controller
 * @author 		Jay
 * @time		2015-6-4
 */
@RestController
@RequestMapping("api/image")
public class ImageController {
	
	@Autowired
	IImageService imageService;
	
	@Autowired
	IFileService fileService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void saveImage(@RequestParam(value = "file") MultipartFile file,@RequestParam(value="summary",defaultValue="") String summary) throws Exception {
		
		String fileId = fileService.save(file.getBytes(), file.getOriginalFilename());
		Image image = new Image();
		image.setSummary(summary);
		image.setPath(fileId);
		
		imageService.saveImage(image);
		
	}
	
	@RequestMapping(value="getImages",method=RequestMethod.GET)
	public PaginationVo getImages(@RequestParam(value="page" ,defaultValue = "1") Integer page,@RequestParam(value="size",defaultValue="6") Integer size){
		PaginationVo paginationVo =  imageService.findImageByPagination(page, size);
		return paginationVo;
	}
	
}

