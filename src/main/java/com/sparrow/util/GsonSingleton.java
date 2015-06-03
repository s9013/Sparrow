package com.sparrow.util;

import com.google.gson.Gson;

/**
 * Gson util
 * @author Jay
 * @time         2015年5月22日
 */
public class GsonSingleton {
	
	private static Gson gson;

	private GsonSingleton() {
	};

	public static Gson getGsonInstance() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}
}
