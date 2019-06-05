package com.zl.vo;

import com.zl.utils.Err;

/**
 * 通用的返回包装类型
 * @author Administrator
 *
 */
public class JsonResult {
	private int code;
	private String msg;
	
	public JsonResult(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public JsonResult() {
	}

	public JsonResult(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return code==Err.SUCESS;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
