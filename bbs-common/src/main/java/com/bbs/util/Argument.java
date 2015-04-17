package com.bbs.util;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

/**
 * 对入参数进行判断
 * 
 * @author jiejie 2014年10月30日 上午10:31:46
 */
public class Argument {

	public static boolean isPositive(Integer argument) {
		return argument != null && argument > 0;
	}

	public static boolean isNotPositive(Integer argument) {
		return argument == null || argument < 0;
	}

	public static boolean isPositive(Number argument) {
		if (argument == null) {
			return false;
		}
		return argument.floatValue() > 0f || argument.intValue() > 0;
	}

	public static boolean isNull(Object argument) {
		return argument == null;
	}

	public static boolean isBlank(String argument) {
		return StringUtils.isBlank(argument);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection argument) {
		return isNull(argument) || argument.isEmpty();
	}

	public static boolean isNotNull(Object argument) {
		return argument != null;
	}

	/**
	 * 判断一个集合部位空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Collection argument) {
		return !isEmpty(argument);
	}

	/**
	 * 判断一个数组不为空
	 */
	public static boolean isNotEmptyArray(Object[] array) {
		return !isEmptyArray(array);
	}

	/**
	 * 判断时一个空数组（null或者length为0）
	 */
	public static boolean isEmptyArray(Object[] array) {
		return isNull(array) || array.length == 0;
	}

	public static boolean isNotBlank(String argument) {
		return StringUtils.isNotBlank(argument);
	}

	/**
	 * 2个Integer是否相等 <br>
	 * Two null references are considered to be equal
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean integerEqual(Integer num1, Integer num2) {
		return num1 == null ? num2 == null : num1.equals(num2);
	}

}
