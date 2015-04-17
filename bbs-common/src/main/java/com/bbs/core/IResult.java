package com.bbs.core;

/**
 * 类IResult.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月25日 下午8:58:56
 */
public interface IResult<T> {

	boolean success();

	String message();

	T data();
}
