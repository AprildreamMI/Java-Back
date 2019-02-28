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
		/*System.out.println("请输入求租客户ID");
		userID=scanf.nextInt();*/
		
		System.out.println("请输入求租客户姓名");
		userName=scanf.next();
		
		System.out.println("请输入求租客户性别");
		String sexStr=scanf.next();
		sex=sexStr.charAt(0);
		
		System.out.println("请输入求租客户电话");
		phone=scanf.next();
		
		System.out.println("请输入求租客户家庭电话");
		homePhone=scanf.next();
		
		System.out.println("请输入求租客户邮箱");
		email=scanf.next();
		
		System.out.println("请输入求租客户QQ号码");
		qq=scanf.next();
				
		System.out.println("请输入求租客户身份证号码");
		cardID=scanf.next();
		
		System.out.println("请输入求租客户编号");
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
