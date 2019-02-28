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
	private String HirePersonNo;//�����˱��
	private Date recordDate;//�Ǽ�����
	public HireUser() 
	{
		super();
		System.out.print("���������๹�췽��");
	}
	public HireUser(int userID,String userName,char sex,String phone, String homePhone,String email,String qq,String cardID,String address,String hirePersonNo,Date recordDate) 
	{
		super(userID,userName,sex,phone,homePhone,email,qq,cardID,address);
		this.HirePersonNo=hirePersonNo;
		this.recordDate=recordDate;
		System.out.println("����������������Ĺ��췽��");
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
		System.out.println("��������ͻ�����ʾ�û��ķ���");
	}
}
