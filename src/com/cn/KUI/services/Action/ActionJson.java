package com.cn.KUI.services.Action;

import net.sf.json.JSONException;

import com.cn.KUI.services.exception.BusinessException;

public interface ActionJson {
	public String execute(String params) throws BusinessException, JSONException;
}
