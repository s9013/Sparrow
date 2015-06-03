package com.sparrow.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

import com.mongodb.gridfs.GridFSDBFile;
import com.sparrow.exception.MyException;
import com.sparrow.service.iface.IFileService;

/**
 * file service implement
 * 
 * @author Jay
 * @time 2015年6月3日
 */
@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	GridFsOperations operations;

	@Override
	public void save(byte[] content, String filename) {

		try {
			operations.store(new ByteArrayInputStream(content), filename);
		} catch (Exception e) {
			e.printStackTrace();
			//throw new MyException(300, "保存失败！");
		}

	}

	@Override
	public byte[] get(String fileName) {
		byte[] result = null;
		try {
			GridFSDBFile file = operations.findOne(Query.query(GridFsCriteria
					.whereFilename().is(fileName)));
			InputStream inputStream = file.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			
		
			while (inputStream.read(buffer) != -1)
				outStream.write(buffer);
			outStream.flush();
			result = outStream.toByteArray();
			inputStream.close();
			outStream.close();
		} catch (Exception e) {
			//throw new MyException(301, "文件不存在！");
		}

		return result;
	}

	@Override
	public void delete(String fileName) {
		// TODO Auto-generated method stub

	}

}
