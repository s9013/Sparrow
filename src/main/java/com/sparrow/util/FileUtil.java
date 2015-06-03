package com.sparrow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

/**
 * File util
 * @author 		Jay
 * @time		2015年6月3日
 */
public class FileUtil {
	
	@Autowired
	GridFsOperations operations;
	
	
	private void save(){
	    // populate metadata
	    File file =  new File("D:/test.jpg"); // lookup File or Resource

	    InputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    operations.store(input, "filename.txt");
	}
	
	
	public static void main(String[] args) throws IOException {
		FileUtil test =new FileUtil();
		test.save();
	}
	
	 
}

