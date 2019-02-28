package realtor;
import java.util.Date;
import java.util.Scanner;

import realtor.*;
public class inut2 extends inut
{
	Scanner scanf=new Scanner(System.in);
	jianyan one=new jianyan();
	public HireUser inutHireUser()
	{
		super.inutHireUser();
		
		boolean checkPhone=one.isDigit(phone);
		if(!checkPhone)
			System.out.println("你输入的电话号码不正确");
		
		boolean checkEmail=one.checkEmail(email);
		if(!checkEmail)
			System.out.println("您输入的邮箱不正确");
		
		boolean checkQq=one.checkQQ(qq);
		if(!checkQq)
			System.out.println("您输的的QQ号码不正确");
		
		boolean checkCardID=one.checkCardID(cardID);
		if(!checkCardID)
			System.out.println("您输入的身份证号码不正确");
		
		System.out.println("请输入记录日期，格式：年-月-日");
		String recordDateStr=scanf.next();
		Date recordDate=one.strTransDate(recordDateStr);
		
		
		hireUser.setRecordDate(recordDate);
		
		return hireUser;
	}
}
