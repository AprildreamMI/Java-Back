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
		System.out.println("�������ͻ���Ϣ");
		//����ͻ���Ϣ
		HireUser hireUser=one.inutHireUser();
		boolean isExist=two.isEixist(hireUser);
		if(isExist)
		{
			System.out.println("���������Ϣ�����Ѵ��ڴ˿ͻ�");
		}
		else {
			two.insertUser(hireUser);
			System.out.println("�������ͻ���Ϣ�ɹ�");
		}
		
	}

}
