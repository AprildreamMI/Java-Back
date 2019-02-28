package magic.bnak;

import java.util.List;

public class User 
{

	private String ID;
	private String Password;
	private String Money;
	
	public User(String ID,String password,String money) 
	{
		this.ID=ID;
		this.Password=password;
		this.Money=money;
	}
	
	public String getID() 
	{
		return ID;
	}
	public void setID(String iD)
	{
		ID = iD;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String password) 
	{
		Password = password;
	}
	public String getMoney()
	{
		return Money;
	}
	public void setMoney(String money)
	{
		Money=money;
	}
	
	
}
	
	
