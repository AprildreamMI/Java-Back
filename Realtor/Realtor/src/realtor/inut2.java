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
			System.out.println("������ĵ绰���벻��ȷ");
		
		boolean checkEmail=one.checkEmail(email);
		if(!checkEmail)
			System.out.println("����������䲻��ȷ");
		
		boolean checkQq=one.checkQQ(qq);
		if(!checkQq)
			System.out.println("����ĵ�QQ���벻��ȷ");
		
		boolean checkCardID=one.checkCardID(cardID);
		if(!checkCardID)
			System.out.println("����������֤���벻��ȷ");
		
		System.out.println("�������¼���ڣ���ʽ����-��-��");
		String recordDateStr=scanf.next();
		Date recordDate=one.strTransDate(recordDateStr);
		
		
		hireUser.setRecordDate(recordDate);
		
		return hireUser;
	}
}
