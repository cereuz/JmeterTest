package com.zao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * timeCurrent  :  ����ϵͳʱ��      ��ʽΪ �� ��-��-��  ʱ���֣��룺����
 */
public class GetSystemTime {
	//��ȡ��ǰʱ��ķ���
	public String getSystemTime(){
	String str1 = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	String str2 = (new SimpleDateFormat("hh:mm:ss.SSS")).format(new Date());
	String str3 = (new SimpleDateFormat("hh:mm:ss")).format(new Date());
	String timeCurrent = str1+" "+str2 + " ";
	return timeCurrent;
	}
}
