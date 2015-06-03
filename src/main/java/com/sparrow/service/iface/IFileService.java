package com.sparrow.service.iface;

/**
 * File接口
 * @author 		Jay
 * @time		2015年6月3日
 */
public interface IFileService {
	
	void save(byte[] content, String filename);
	
	byte[] get(String fileName);
	
	void delete(String fileName);
	
}

