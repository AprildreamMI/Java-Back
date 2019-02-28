package com.wj.real;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BufferedPrintStream
{
	public static void main(String[] args)
	{
		try {
			BufferedReader bureader=new BufferedReader
					(new InputStreamReader
							(new FileInputStream("c://PrinStream.txt")));
			PrintStream pStream=new PrintStream("d://PrinStream.txt");
			
			String line=null;
			
			try {
				while ((line=bureader.readLine())!=null) 
				{
					pStream.println(line);
				}
				pStream.close();
				bureader.close();
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
