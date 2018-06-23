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
	 * ����ȡ���� �ֶ���Ϣ д�������ļ� String text ��Ҫд���ļ�����Ϣ String pathname д���ļ���·��
	 */
	public void writeToFile(String text, String pathname) {
		/*
		 * pathname �ĸ�ʽ ��
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
						file.getAbsoluteFile(), true);// true��ʾ���ļ�ĩβ׷��
				fos.write(text.getBytes());
				fos.write("\n".getBytes());
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param index     ��ȡ���������� 0 ��ʼ
	 *            
	 * @param fileName  ��ȡ�ļ���·��
	 * 
	 * @param out ��������ݣ� 0:��ȡ���һ��    1:����index���������ȡ  -1:ȫ����ȡ
	 * 
	 * @return ���ض�ȡ������ֵ
	 * 
	 */
	public String readCSV(int index, String fileName, int out) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));// ��������ļ���
			// reader.readLine();//��һ����Ϣ��Ϊ������Ϣ������,�����Ҫ��ע��ȥ��
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
