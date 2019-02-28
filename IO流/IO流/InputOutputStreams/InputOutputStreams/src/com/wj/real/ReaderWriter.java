package com.wj.real;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriter 
{
	public static void main(String[] args) 
	{
		try {
			Reader duReader=new FileReader("c://writer.txt");
		    Writer quWriter=new FileWriter("d://writer.txt");
		    
		    int temp=0;
		    while ((temp=duReader.read())!=-1) 
		    {
				quWriter.write(temp);
			}
		    quWriter.close();
		    duReader.close();
		}catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
