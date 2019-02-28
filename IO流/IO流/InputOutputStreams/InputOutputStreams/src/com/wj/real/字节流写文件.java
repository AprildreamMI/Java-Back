package com.wj.real;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class 字节流写文件
{
	public static void main(String[] args) 
	{
		try {
			//创建一个字节输出流对象
			OutputStream osOutputStream=new FileOutputStream("C://one.txt");
			String string="今天天气不错";
			try {
				osOutputStream.write(string.getBytes());  //转化为字节
				osOutputStream.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
