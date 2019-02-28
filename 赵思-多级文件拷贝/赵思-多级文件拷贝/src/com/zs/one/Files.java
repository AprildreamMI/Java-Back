package com.zs.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Administrator
 * 在C盘创建一个多级目录及文件，然后拷贝到D盘中去
 */
public class Files 
{
	public void copy(File file)
	{
		try {
			Reader reader=new FileReader(file);
			Writer writer = new FileWriter("D:\\");
			
			int temp=0;
			while ((temp=reader.read())!=-1)
			{
				writer.write(temp);
			}
			
			reader.close();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		//给定了一个多级目录
		File file1 = new File("c:\\aaa\\bbb\\ccc\\ycy.txt");
		//创建了多级目录
		File dFile1=file1.getParentFile();
		if (!dFile1.exists()) {
			dFile1.mkdirs();
		}
		//又在多级目录下创建了一个目录
		File file2 = new File("c:\\aaa\\bbb\\ddd");
		if(!file2.exists())
		{
			file2.mkdir();
		}
		//创建了多级目录下的文件
		try {
			file1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
