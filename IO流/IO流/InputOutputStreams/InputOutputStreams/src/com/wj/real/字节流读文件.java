package com.wj.real;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Shinelon
 * �ֽ������ļ�
 */
public class �ֽ������ļ� 
{
	public static void main(String[] args) 
	{
		try {
			InputStream rOutput=new FileInputStream("c://one.txt");//�˳������Ǳ�ʾ�ֽ���������������ĳ��ࡣ 
			byte b[]=new byte[1024];
			
			try {
				int length=rOutput.read(b); //���������ж�ȡһ���������ֽڣ�������洢�ڻ��������� b �С���������ʽ����ʵ�ʶ�ȡ���ֽ�����
				String bString=new String(b);
				System.out.println(bString);
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
