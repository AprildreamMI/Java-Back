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
 * ��C�̴���һ���༶Ŀ¼���ļ���Ȼ�󿽱���D����ȥ
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
		//������һ���༶Ŀ¼
		File file1 = new File("c:\\aaa\\bbb\\ccc\\ycy.txt");
		//�����˶༶Ŀ¼
		File dFile1=file1.getParentFile();
		if (!dFile1.exists()) {
			dFile1.mkdirs();
		}
		//���ڶ༶Ŀ¼�´�����һ��Ŀ¼
		File file2 = new File("c:\\aaa\\bbb\\ddd");
		if(!file2.exists())
		{
			file2.mkdir();
		}
		//�����˶༶Ŀ¼�µ��ļ�
		try {
			file1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
