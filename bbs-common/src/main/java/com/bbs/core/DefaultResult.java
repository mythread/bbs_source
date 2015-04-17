package com.bbs.core;

/**
 * 类DefaultResult.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月25日 下午9:08:08
 */
public class DefaultResult<T> implements IResult<T> {

	private boolean success;
	private String message;
	private T data;

	public DefaultResult(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public static <T> IResult<T> failResult(String message, T data) {
		return new DefaultResult<T>(false, message, data);
	}

	public static <T> IResult<T> successResult(String message, T data) {
		return new DefaultResult<T>(true, message, data);
	}

	@Override
	public boolean success() {
		return success;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public T data() {
		return data;
	}

}
