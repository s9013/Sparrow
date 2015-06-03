package com.sparrow.service.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sparrow.service.iface.ISmsService;

/**
 * @author Jay
 * @time 2015年5月27日
 */
@Service
public class SmsServiceImpl implements ISmsService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	Environment env;

	@Override
	public void sendMessage(String mobile, String message) {
		String url = "";
		try {
			url = env.getProperty("smsUrl") + "&destnumbers= " + mobile
					+ "&msg=" + message;
			java.net.URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String result = restTemplate.postForObject(url, null, String.class);
		System.out.println(result);
	}

}
