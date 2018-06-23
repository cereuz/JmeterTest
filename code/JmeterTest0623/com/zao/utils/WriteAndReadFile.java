package com.zao.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WriteAndReadFile {
	/**
	 * 将获取到的 字段信息 写到本地文件 String text 需要写入文件的信息 String pathname 写入文件的路径
	 */
	public void writeToFile(String text, String pathname) {
		/*
		 * pathname 的格式 ：
		 * "E:\\java\\java\\Jmeter4.0\\apache-jmeter-4.0\\testuse\\msr0613\\code\\token0623.txt"
		 * String text = getTime() + " token0622 : " + vars.get("token0622");
		 */
		try {
			File file = new File(pathname);
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(
							file.getAbsolutePath()), "UTF-8"));
			String str = "";
			boolean isExist = false;
			while ((str = bufferedReader.readLine()) != null) {
				if (str.trim().equals(text)) {
					isExist = true;
					break;
				}
			}
			bufferedReader.close();
			if (!isExist) {
				FileOutputStream fos = new FileOutputStream(
						file.getAbsoluteFile(), true);// true表示在文件末尾追加
				fos.write(text.getBytes());
				fos.write("\n".getBytes());
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param index     读取的行数，从 0 开始
	 *            
	 * @param fileName  读取文件的路径
	 * 
	 * @param out 输出的内容， 0:读取最后一行    1:按照index的序号来读取  -1:全部读取
	 * 
	 * @return 返回读取的行数值
	 * 
	 */
	public String readCSV(int index, String fileName, int out) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));// 换成你的文件名
			// reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释去掉
			String text = null;
			ArrayList<String> list = new ArrayList<String>();
			while ((text = reader.readLine()) != null) {
				list.add(text);
			}
			if (out == 0) {
				text = list.get(list.size() - 1);
			} else if(out == 1 && index <= list.size()) {
				text = list.get(index - 1);
			} else if(out == -1){
				text = list.toString();
			}
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
