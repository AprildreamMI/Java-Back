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
			//从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。 重点实现行读取
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
