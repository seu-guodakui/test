package com.cn.KUI.services.JsonBean;

import net.sf.json.JSONException;

import com.cn.KUI.services.Action.ActionJson;
import com.cn.KUI.services.exception.BusinessException;


public class LoginBean implements ActionJson {
	public String execute(String params) throws BusinessException, JSONException
	{
		
		return "now in login";
	}
}
