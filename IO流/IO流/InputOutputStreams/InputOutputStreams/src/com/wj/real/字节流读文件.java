package com.wj.real;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Shinelon
 * 字节流读文件
 */
public class 字节流读文件 
{
	public static void main(String[] args) 
	{
		try {
			InputStream rOutput=new FileInputStream("c://one.txt");//此抽象类是表示字节输入流的所有类的超类。 
			byte b[]=new byte[1024];
			
			try {
				int length=rOutput.read(b); //从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。以整数形式返回实际读取的字节数。
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
