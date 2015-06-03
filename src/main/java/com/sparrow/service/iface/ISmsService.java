package com.sparrow.service.iface;

/**
 * SMS接口
 * @author       Jay
 * @time         2015年5月27日
 */
public interface ISmsService {
	
	/**
	 * 发送消息
	 * @param mobile	手机号
	 * @param message	消息
	 */
	void sendMessage(String mobile,String message);
	
}
