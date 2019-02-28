package com.wj.real;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter 
{
	public static void main(String[] args) 
	{
		try {
			Writer writer=new FileWriter("c://writer.txt");
			String string="清明时节雨纷纷";
			char[] ch=string.toCharArray();
			for (char c:ch) 
			{
				writer.write(c);
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
