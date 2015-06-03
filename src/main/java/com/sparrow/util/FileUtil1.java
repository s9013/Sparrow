package com.sparrow.util;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * File util
 * @author 		Jay
 * @time		2015年6月3日
 */
public class FileUtil1 {
	
	public static void main(String[] args) throws IOException {
		Mongo mongo = new Mongo();  
	    DB db = mongo.getDB("SparrowDB");   //创建数据库连接  
	    GridFS myFS = new GridFS(db,"File"); //创建GridFS   对mongoDBFile数据库中的user1进行操作，这样文件的读取和删除都是user1中的文件  
	      
	    //保存文件  
	   // GridFSFile file = myFS.createFile(new File("D:/test.jpg"));  
	   // file.save();
	      
	    //输出文件  
	   //GridFSDBFile file =myFS.findOne("test.jpg"); 
	   // file.writeTo(new File("D:/image1.jpg")); 
	      
	     //删除文件  
	    GridFSDBFile file =myFS.findOne("test.jpg"); 
	    myFS.remove((ObjectId) file.getId());
	}
	
	 
}

