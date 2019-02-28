package realtor;

import org.omg.CORBA.portable.Streamable;

public class Customer 
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
	public Customer()
	{
		System.out.println("这是客户类的构造方法");
	}
	public Customer(int userID,String userNmae,char sex,String phone, String homePhone,String email,String qq,String cardID,String address) 
	{
		System.out.println("这是客户类带参数的构造方法");
		this.userID=userID;
		this.userName=userNmae;
		this.sex=sex;
		this.phone=phone;
		this.homePhone=homePhone;
		this.email=email;
		this.qq=qq;
		this.cardID=cardID;
		this.address=address;
	}
	public int getUserID() 
	{
		return userID;
	}
	public void setUserID(int userID) 
	{
		this.userID=userID;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userNmae) 
	{
		this.userName=userNmae;
	}
	public char getSex() 
	{
		return sex;
	}
	public void setSex(char sex)
	{
		this.sex=sex;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhoen(String phone) 
	{
		this.phone=phone;
	}
	public String getHomePhone() 
	{
		return homePhone;
	}
	public void setHomePhone(String homePhone) 
	{
		this.homePhone=homePhone;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getQQ() 
	{
		return qq;
	}
	public void setQQ(String qq)
	{
		this.qq=qq;
	}
	public String getcardID()
	{
		return cardID;
	}
	public void setCardID(String cardID)
	{
		this.cardID=cardID;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void showUserName()
	{
		System.out.println("客户的姓名为:"+userName);
	}
}
