package com.lbs.utils;

public class MathUtils {
	
	/**
	 * 是否是数字
	 * @param str
	 * @return
	 */
	public static boolean IsDouble(String str){
		try{
			Double.parseDouble(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
