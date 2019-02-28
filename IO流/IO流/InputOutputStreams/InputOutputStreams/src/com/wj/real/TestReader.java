package com.wj.real;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestReader 
{
	public static void main(String[] args)
	{
		try {
			Reader reader=new FileReader("c://one.txt");
			char[] c=new char[1024];
			int temp=0;
			try {
				while ((temp=reader.read())!=-1)
				{
					System.out.println((char)temp);
				}
				reader.close();
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
