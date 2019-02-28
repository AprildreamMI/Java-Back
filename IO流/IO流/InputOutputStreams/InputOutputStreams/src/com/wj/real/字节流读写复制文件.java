package com.wj.real;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class 字节流读写复制文件 
{
	public static void main(String[] args) 
	{
		try {
			InputStream rOutput=new FileInputStream("c://one.txt");
			OutputStream wStream=new FileOutputStream("d://two.txt");		
			try {
				byte b[]=new byte[1024];
				int temp=0;
				while (rOutput.read(b)!=-1)
				{
					wStream.write(b, 0, temp);
				}
				rOutput.close();
				wStream.close();
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
