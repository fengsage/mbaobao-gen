package com.mbaobao.gen.util;

import java.util.List;

/**
 * 字符串工具函数                      
 * @Filename: StringUtil.java
 * @Version: 1.0
 * @Author: rongmai 刘志斌
 * @Email: rongmai@mbaobao.com
 *
 */
public final class StringUtil {
	
	public static <T> String listToString(List<T> list, String split) {
		StringBuffer buf = new StringBuffer();
		int size = list.size();
		for (T t : list) {
			if (--size != 0) {
				buf.append(t.toString()).append(split);
			} else {
				buf.append(t.toString());
			}
		}
		return buf.toString();
	}
	
	/**
	 * 检查字符串是否为空
	 * <p>为null或者长度为0视为空字符串
	 * @param value 要检查的字符串
	 * @param trim 是否去掉头尾的特定字符
	 * @param trimChars 要去掉的特定字符
	 * @return
	 */
	public static boolean isEmpty(String value, boolean trim, char... trimChars) {
		if (trim)
			return value == null || trim(value, trimChars).length() <= 0;
		return value == null || value.length() <= 0;
	}
	
	/**
	 * 检查字符串是否为空
	 * <p>为null或者长度为0视为空字符串
	 * @param value 要检查的字符串
	 * @param trim 是否去掉头尾的空格
	 * @return
	 */
	public static boolean isEmpty(String value, boolean trim) {
		return isEmpty(value, trim, ' ');
	}
	
	/**
	 * 检查字符串是否为空
	 * <p>为null或者长度为0视为空字符串
	 * @param value 要检查的字符串
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return isEmpty(value, false);
	}
	
	/**
	 * 如果为null，转换为""
	 * @param value
	 * @return
	 */
	public static String nullSafeString(String value) {
		return value == null ? "" : value;
	}
	
	/**
	 * 去掉头尾空格字符
	 * @param value 待处理的字符串
	 * @return
	 */
	public static String trim(String value) {
		return trim(3, value, ' ');
	}
	
	/**
	 * 去除字符串头尾的特定字符
	 * 
	 * @param value 待处理的字符串
	 * @param chars 需要去掉的特定字符
	 * @return
	 */
	public static String trim(String value, char... chars) {
		return trim(3, value, chars);
	}
	
	/**
	 * 去除字符串头部的特定字符
	 * 
	 * @param value 待处理的字符串
	 * @param chars 需要去掉的特定字符
	 * @return
	 */
	public static String trimStart(String value, char... chars) {
		return trim(1, value, chars);
	}
	
	/**
	 * 去除字符串尾部的特定字符
	 * @param value 待处理的字符串
	 * @param chars 需要去掉的特定字符
	 * @return
	 */
	public static String trimEnd(String value, char... chars) {
		return trim(2, value, chars);
	}
	
	/**
	 * 去掉字符串头尾特定字符
	 * @param mode 
	 * <li>1: 去掉头部特定字符；
	 * <li>2: 去掉尾部特定字符；
	 * <li>3: 去掉头尾特定字符；
	 * @param value 待处理的字符串
	 * @param chars 需要去掉的特定字符
	 * @return
	 */
	private static String trim(int mode, String value, char... chars) {
		if (value == null || value.length() <= 0)
			return value;
		
		int startIndex = 0, endIndex = value.length(), index = 0;
		if (mode == 1 || mode == 3) {
			// trim头部
			while (index < endIndex) {
				if (contains(chars, value.charAt(index++))) {
					startIndex++;
					continue;
				}
				break;
			}
		}
		
		if (startIndex >= endIndex)
			return "";
		
		if (mode == 2 || mode == 3) {
			// trim尾部
			index = endIndex - 1;
			while (index >= 0) {
				if (contains(chars, value.charAt(index--))) {
					endIndex--;
					continue;
				}
				break;
			}
		}
		
		if (startIndex >= endIndex)
			return "";
		
		return value.substring(startIndex, endIndex);
	}
	
	private static boolean contains(char[] chars, char chr) {
		if (chars == null || chars.length <= 0)
			return false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == chr)
				return true;
		}
		return false;
	}
}