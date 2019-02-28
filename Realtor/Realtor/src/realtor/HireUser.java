package realtor;

import java.util.Date;

public class HireUser extends Customer 
{
	private int userID;
	public String userName;
	private char sex;
	protected String phone;
	private String homePhone;
	private String email;
	private String qq;
	private String cardID;
	private String address;
	private String HirePersonNo;//求租人编号
	private Date recordDate;//登记日期
	public HireUser() 
	{
		super();
		System.out.print("这是求租类构造方法");
	}
	public HireUser(int userID,String userName,char sex,String phone, String homePhone,String email,String qq,String cardID,String address,String hirePersonNo,Date recordDate) 
	{
		super(userID,userName,sex,phone,homePhone,email,qq,cardID,address);
		this.HirePersonNo=hirePersonNo;
		this.recordDate=recordDate;
		System.out.println("这是求租类带参数的构造方法");
	}
	public String getHirePersonNo() 
	{
		return HirePersonNo;
	}
	public void setHirePersonNo(String hirePersonNo) 
	{
		HirePersonNo=hirePersonNo;
	}
	public Date getRecordDate()
	{
		return recordDate;
	}
	public void setRecordDate(Date recordDate)
	{
		this.recordDate=recordDate;
	}
	public void showUserName() 
	{
		super.showUserName();
		System.out.println("这是求租客户类显示用户的方法");
	}
}
