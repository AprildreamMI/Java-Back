package com.wj.real;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class �ֽ���д�ļ�
{
	public static void main(String[] args) 
	{
		try {
			//����һ���ֽ����������
			OutputStream osOutputStream=new FileOutputStream("C://one.txt");
			String string="������������";
			try {
				osOutputStream.write(string.getBytes());  //ת��Ϊ�ֽ�
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
