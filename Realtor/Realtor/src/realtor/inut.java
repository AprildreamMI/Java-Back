package realtor;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

import realtor.HireUser;;

public class inut
{
	int userID;
	String userName;
	char sex;
	String phone;
	String homePhone;
	String email;
	String qq;
	String cardID;
	String hirePersonNo;
	Scanner scanf=new Scanner(System.in);
	HireUser hireUser=new HireUser();
	public HireUser inutHireUser()
	{
		/*System.out.println("����������ͻ�ID");
		userID=scanf.nextInt();*/
		
		System.out.println("����������ͻ�����");
		userName=scanf.next();
		
		System.out.println("����������ͻ��Ա�");
		String sexStr=scanf.next();
		sex=sexStr.charAt(0);
		
		System.out.println("����������ͻ��绰");
		phone=scanf.next();
		
		System.out.println("����������ͻ���ͥ�绰");
		homePhone=scanf.next();
		
		System.out.println("����������ͻ�����");
		email=scanf.next();
		
		System.out.println("����������ͻ�QQ����");
		qq=scanf.next();
				
		System.out.println("����������ͻ����֤����");
		cardID=scanf.next();
		
		System.out.println("����������ͻ����");
		hirePersonNo=scanf.next();
		
		

		/*hireUser.setUserID(userID);*/
		hireUser.setUserName(userName);
		hireUser.setPhoen(phone);
		hireUser.setHomePhone(homePhone);
		hireUser.setEmail(email);
		hireUser.setQQ(qq);
		hireUser.setCardID(cardID);
		hireUser.setHirePersonNo(hirePersonNo);
		return hireUser;
		
	}
}
