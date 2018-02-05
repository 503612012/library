package com.skyer.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件
 * 
 * @author Zongqian
 */
public class Config {

	// 声明相关的参数
	private static String imageUploadPath = "";
	private static String imageUrl = "";

	private static Properties p = new Properties();

	static {
		load();
	}

	synchronized static void load() {
		try {
			// 读取配置文件config.properties
			p.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));

			// 获取配置文件中的相关参数值
			imageUploadPath = p.getProperty("image.upload.path");
			imageUrl = p.getProperty("image.url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取上传图片地址
	 */
	public static String getImageUploadPath() {
		return imageUploadPath;
	}

	/**
	 * 获取图片访问路径
	 */
	public static String getImageUrl() {
		return imageUrl;
	}

}
