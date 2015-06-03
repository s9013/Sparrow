package com.sparrow.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sparrow.service.iface.IFileService;

/**
 * File controller
 * 
 * @author Jay
 * @time 2015年6月3日
 */
@RestController
@RequestMapping("api/file")
public class FileController {

	@Autowired
	IFileService fileService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void saveFile(@RequestParam(value = "file") MultipartFile file) {
		try {
			// 文件类型 大小的判断
			fileService.save(file.getBytes(), file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public void getFile(String fileName, HttpServletResponse response){
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			byte[] result = fileService.get(fileName);
			if(null != result){
				os.write(fileService.get(fileName)); 
			}
		} catch (IOException e) {
			
		}
		
	}
}
