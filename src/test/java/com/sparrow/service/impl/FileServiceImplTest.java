package com.sparrow.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sparrow.SparrowApplicationTests;
import com.sparrow.service.iface.IFileService;

/**
 * description
 * @author 	Jay
 * @time		2015年6月3日
 */
public class FileServiceImplTest extends SparrowApplicationTests{

	@Autowired
	IFileService service;
	
	@Ignore
	@Test
	public void testSvae() throws IOException {
		
		File file = new File("D:/image1.jpg"); // lookup File or Resource

		InputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
        byte[] b = new byte[1000];  
        int n;  
        while ((n = input.read(b)) != -1) {  
            bos.write(b, 0, n);  
        }  
        input.close();  
        bos.close();  
		service.save(bos.toByteArray(),file.getName());
	}
	

	@Ignore
	@Test
	public void testGet() {
		service.get("test");
	}
	
	@Test
	public void testGetById() {
		print(service.getFileById("556fc2627da227f7ae0a3270"));
	}
	
	

}

