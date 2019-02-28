package realtor;
import java.util.Scanner;

import realtor.*;
public class HireUserTest 
{
	public static void main(String[] args) 
	{
		Scanner scanf=new Scanner(System.in);
		inut2 one=new inut2();
		HireUserDAOImp two=new HireUserDAOImp();
		HireUserTest hTest=new HireUserTest();
		System.out.println("添加求租客户信息");
		//输入客户信息
		HireUser hireUser=one.inutHireUser();
		boolean isExist=two.isEixist(hireUser);
		if(isExist)
		{
			System.out.println("您输入的信息有误，已存在此客户");
		}
		else {
			two.insertUser(hireUser);
			System.out.println("添加求租客户信息成功");
		}
		
	}

}
