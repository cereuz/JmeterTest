package com.zao.test;

import com.zao.utils.GetSystemTime;
import com.zao.utils.WriteAndReadFile;


public class Test0622 {
	public static void main(String[] args) {
		String tokenText = new GetSystemTime().getSystemTime() + " token :" ;//+  token;
		String pathText = "E:\\java\\java\\Jmeter4.0\\apache-jmeter-4.0\\testuse\\msr0613\\code\\token062301.txt";
		tokenText = new WriteAndReadFile().readCSV(9,pathText,1);
          System.out.println(tokenText);	
	}
}
