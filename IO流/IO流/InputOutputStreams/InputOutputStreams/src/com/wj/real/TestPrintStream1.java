package com.wj.real;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestPrintStream1 
{
	public static void main(String[] args) 
	{
		try {
			PrintStream stream=new PrintStream("c://PrinStream.txt");
			String linString="·���������ϻ�";
			stream.println(linString);//д�����
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
