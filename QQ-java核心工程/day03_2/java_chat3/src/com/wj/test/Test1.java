package com.wj.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
		public static void main(String[] args) {
			Date  date=new Date();
			System.out.println(date);
			//格式化时间
			//2018年3月19号【空格】 11:15:55  	星期一
			SimpleDateFormat  dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			System.out.println(dFormat.format(date));
		}
}
