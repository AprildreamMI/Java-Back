package com.wj.real;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBuffered1 
{
	public static void main(String[] args) 
	{
		try 
		{
			//���ַ��������ж�ȡ�ı�����������ַ����Ӷ�ʵ���ַ���������еĸ�Ч��ȡ�� �ص�ʵ���ж�ȡ
			BufferedReader rBufferedReader=
					new BufferedReader
					(new InputStreamReader
							(new FileInputStream("c://reader.txt")));
			String lineString=null;
			
			while ((lineString=rBufferedReader.readLine())!=null)
			{
				System.out.println(lineString);	
			}
			rBufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}	 
		
	}
}
