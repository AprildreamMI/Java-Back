package realtor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.text.StyledEditorKit.BoldAction;

public class jianyan 
{
	//�����Ƿ�Ϊ����
	public boolean isDigit(String input)
	{
		boolean flag=true;
		char[] inputs=input.toCharArray();
		for(int i=0;i<inputs.length;i++)
		{
			char c=inputs[i];
			if(!Character.isDigit(c))
			{
				flag=false;
				break;
			}else {
				continue;
			}
		}
		return flag;
	}
	//�������
	public boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			String check="^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?.)+[a-zA-Z]{2,}$";
			Pattern regex=Pattern.compile(check);
			Matcher matcher=regex.matcher(email);
			flag=matcher.matches();
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	//QQ�������
	public boolean checkQQ(String myQQstr)
	{
		boolean flag=false;
		String regex="[1-9][0-9]{4,14}";
		if(myQQstr.matches(regex))
		{
			flag=true;
		}
		return flag;
	}
	//������֤
	public boolean checkCardID(String cardID)
	{
		boolean flag=true;
		if(cardID.length()==18)
		{
			String yearStr=cardID.substring(6, 10);
			String monthStr=cardID.substring(10, 12);
			String dayStr=cardID.substring(12, 14);
			flag=this.checkDate(yearStr,monthStr,dayStr);
		}
		else {
			System.out.println("����������֤����:"+cardID+"���Ȳ���");
		}
		return flag;
	}
	public boolean checkDate(String yearStr,String monthStr,String dayStr) 
	{
		boolean flag=true;
		int year=Integer.parseInt(yearStr);
		System.out.println("year="+year);
		//�ж����
		if (year<1930||year>2013)
		{
			flag=false;
			System.out.println("����������֤����ݲ���1930-2013��֮��");
		}
		//�ж��·�
		char c=monthStr.charAt(0);
		if(c=='0')//����·�С��10����0ȥ��
		{
			monthStr=monthStr.substring(1);
		}
		int month=Integer.parseInt(monthStr);
		if(month<1||month>12)
		{
			flag=false;
			System.out.println("��������·ݲ���ȷ");
		}
		//�ж�����
		char d=dayStr.charAt(0);
		if(d=='0')//����·�С��10����0ȥ��
		{
			dayStr=dayStr.substring(1);
		}
		int day=Integer.parseInt(dayStr);
		GregorianCalendar gCalendar=new GregorianCalendar(year,month,day);
		boolean isLeap=gCalendar.isLeapYear(year);
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
		{
			if(day<1||day>31)
			{
				flag=false;
				System.out.println("����������֤�е����ڲ���ȷ");
			}
		}
		if(month==4||month==6||month==9||month==11)
		{
			if(day<1||day>30)
			{
				flag=false;
				System.out.println("����������֤�е����ڲ���ȷ");
			}
		}
		if(isLeap&&month==2)
		{
			if(day<1||day>28)
			{
				flag=false;
				System.out.println("����������֤�е����ڲ���ȷ");
			}
		}
		return flag;
	}
	
	//������ַ���ת��Ϊ��������
	public Date strTransDate(String inputDate)
	{
		DateFormat dateFormat=new SimpleDateFormat("yyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
