package com.bbs.core;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
	private boolean success;
	private String msg;
	private Object data;
	private Map<String, Object> extras;

	public JsonResult(boolean success) {
		this(success, "");
	}

	public JsonResult(boolean success, Object data) {
		this(success, "", data);
	}

	public JsonResult(boolean success, String msg) {
		this(success, msg, null);
	}

	public JsonResult(boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void addExtra(String key, Object value) {
		if (this.extras == null) {
			this.extras = new HashMap<String, Object>();
		}
		this.extras.put(key, value);
	}
}
