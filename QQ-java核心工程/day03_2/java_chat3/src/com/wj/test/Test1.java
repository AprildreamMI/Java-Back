package com.wj.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
		public static void main(String[] args) {
			Date  date=new Date();
			System.out.println(date);
			//��ʽ��ʱ��
			//2018��3��19�š��ո� 11:15:55  	����һ
			SimpleDateFormat  dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			System.out.println(dFormat.format(date));
		}
}
