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
	//检验是否为数字
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
	//邮箱检验
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
	//QQ号码检验
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
	//检查身份证
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
			System.out.println("您输入的身份证号码:"+cardID+"长度不对");
		}
		return flag;
	}
	public boolean checkDate(String yearStr,String monthStr,String dayStr) 
	{
		boolean flag=true;
		int year=Integer.parseInt(yearStr);
		System.out.println("year="+year);
		//判断年份
		if (year<1930||year>2013)
		{
			flag=false;
			System.out.println("您输入的身份证的年份不在1930-2013年之间");
		}
		//判断月份
		char c=monthStr.charAt(0);
		if(c=='0')//如果月份小于10，把0去掉
		{
			monthStr=monthStr.substring(1);
		}
		int month=Integer.parseInt(monthStr);
		if(month<1||month>12)
		{
			flag=false;
			System.out.println("您输入的月份不正确");
		}
		//判断日期
		char d=dayStr.charAt(0);
		if(d=='0')//如果月份小于10，把0去掉
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
				System.out.println("您输入的身份证中的日期不正确");
			}
		}
		if(month==4||month==6||month==9||month==11)
		{
			if(day<1||day>30)
			{
				flag=false;
				System.out.println("您输入的身份证中的日期不正确");
			}
		}
		if(isLeap&&month==2)
		{
			if(day<1||day>28)
			{
				flag=false;
				System.out.println("您输入的身份证中的日期不正确");
			}
		}
		return flag;
	}
	
	//输入的字符串转换为日期类型
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
