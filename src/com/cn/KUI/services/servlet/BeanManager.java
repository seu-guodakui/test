package com.cn.KUI.services.servlet;

import java.io.IOException;
import java.util.Properties;

import com.cn.KUI.services.Action.ActionJson;

public class BeanManager {

	private Properties p = null;

	public BeanManager() {
		p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("Bean.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getClass(String key) {
		return p.getProperty(key);
	}
	
	public ActionJson createJsonAction(String className) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			Class cls = loader.loadClass(className);
			return (ActionJson)cls.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
		
	}
}
