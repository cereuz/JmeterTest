package com.zao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * timeCurrent  :  返回系统时间      格式为 ： 年-月-日  时：分：秒：毫秒
 */
public class GetSystemTime {
	//获取当前时间的方法
	public String getSystemTime(){
	String str1 = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	String str2 = (new SimpleDateFormat("hh:mm:ss.SSS")).format(new Date());
	String str3 = (new SimpleDateFormat("hh:mm:ss")).format(new Date());
	String timeCurrent = str1+" "+str2 + " ";
	return timeCurrent;
	}
}
