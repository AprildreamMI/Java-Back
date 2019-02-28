package realtor;
import realtor.HireUser;
public class HireUserDAOImp implements UserDAO 
{
	private HireUser[] hu=new HireUser[2];
	public HireUserDAOImp() 
	{
		for(int i=0;i<hu.length;i++)
		{
			hu[i]=new HireUser();
			hu[i].setUserID(i+1);
		}
	}
	public boolean isEixist(HireUser hireUser) 
	{
		boolean flag=false;
		for(int i=0;i<hu.length;i++)
		{
			if(hu[i].getUserID()==hireUser.getUserID())
			{
				flag=true;//用户已存在
				break;
			}
		}
		return flag;
	}
	public void insertUser(HireUser hireUser)
	{
		int length=hu.length;
		if(hireUser instanceof HireUser)
		{
			HireUser[] h=hu;
			hu=new HireUser[length+1];
			for(int i=0;i<h.length;i++)
			{
				hu[i]=h[i];
			}
			hu[length]=hireUser;
		}
		else {
			System.out.println("不是客户对象");
		}
	}
}
