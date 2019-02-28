package magic.bnak;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login 
{
	public static Reader currentUserReader;
	
	
	JFrame login=new JFrame("用户登录");
	
	Box NamePassword=Box.createVerticalBox();
	
	JPanel nameP=new JPanel();
	JPanel passwordP=new JPanel();
	JPanel Jbutton=new JPanel();
	
	BoxLayout boxLayout=new BoxLayout(login.getContentPane(), BoxLayout.Y_AXIS);
	
	JLabel Test=new JLabel("M W 储 蓄 银 行");
	JLabel Name= new JLabel("用户名:");
	JLabel Password=new JLabel("密    码:");
	
	TextField nameT=new TextField(20);
	TextField passwordT=new TextField(20);
	
	JButton log=new JButton("登 录");
	JButton zhuce=new JButton("注 册");
	
	
	
    JFrame Zlogin=new JFrame("用户注册");
	
	
	JPanel ZnameP=new JPanel();
	JPanel ZpasswordP=new JPanel();
	JPanel ZQpasswordP=new JPanel();
	
	BoxLayout ZboxLayout=new BoxLayout(Zlogin.getContentPane(), BoxLayout.Y_AXIS);
	
	JLabel ZTest=new JLabel("注   册");
	JLabel ZName= new JLabel("用户名:");
	JLabel ZPassword=new JLabel("密    码:");
	JLabel ZQPassword=new JLabel("确认密码:");
	
	TextField ZnameT=new TextField(20);
	TextField ZpasswordT=new TextField(20);
	TextField ZQpasswordT=new TextField(20);
	
	JButton Zqueding=new JButton("确定");
	
	
	
	public Login()
	{
		login.setLayout(boxLayout);
		login.setSize(385, 295);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font TextFont=new Font("黑体", Font.BOLD, 16);//建立标题字体
		Test.setFont(TextFont);//设置标题字体
		
		login.add(Box.createVerticalStrut(25));//添加顶部间距
		login.add(Test);//添加标题
		Test.setAlignmentX(Component.CENTER_ALIGNMENT);
		login.add(Box.createVerticalStrut(30));//添加中部间距
		
		nameP.setBackground(new Color(255, 255, 255));
		nameP.add(Name);
		nameP.add(nameT);
		//nameP.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		passwordP.setBackground(new Color(255, 255, 255));
		passwordP.add(Password);
		passwordP.add(passwordT);
		//passwordP.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		login.add(nameP);
		login.add(passwordP);
		login.add(Box.createVerticalStrut(40));//添加底部间距
		
		log.setBackground(new Color(112, 206, 248));
		log.setFont(new Font("宋体", Font.PLAIN, 14));
		//log.setAlignmentX(Component.CENTER_ALIGNMENT);
		log.setForeground(new Color(255, 255, 255));
		Jbutton.add(log);
		
		log.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for (int i = 0; i <init.userList.size(); i++) 
				{
					System.out.println(init.userList.get(i).getID());
					System.out.println(init.userList.get(i).getPassword());
					System.out.println(Name.getText());
					if(init.userList.get(i).getID().equals(nameT.getText()))
					{
						if(init.userList.get(i).getPassword().equals(passwordT.getText()))
						{
							init.currentUser=init.userList.get(i);
							init.userFile=new File(init.currentUser.getID()+".text");
							init.recordString=new StringBuilder();//清空，避免将上一个用户的记录写进新登录的用户中
							
							//创建当前用户文件
							File userFile=new File(init.currentUser.getID()+".text");
							if(!(userFile.exists()))
							{
								try {
									userFile.createNewFile();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showInternalMessageDialog(login, "创建用户文件失败");
								}
							}
							init.userFile=userFile;
							
							
							//读取当前用户记录文件
							try {
								currentUserReader=new FileReader(init.userFile);
								
							} catch (FileNotFoundException e1) {
								JOptionPane.showInternalMessageDialog(login, "读取当前用户记录文件失败");
							}
							
							BufferedReader uBufferedReader=new BufferedReader(currentUserReader);
							
							String tem="";
							try {
								while ((tem=uBufferedReader.readLine())!=null) 
								{
									init.recordString.append(tem);//读取原先该账户的记录的每一行并拼接到Test.recordString中，在inqury类中输出作为查询记录的结果
									
								}
							} catch (IOException e1) {
								JOptionPane.showInternalMessageDialog(login, "拼接当前用户文件记录失败");
							}
							
							
							Menu menu=new Menu();
							login.setVisible(false);
							
						} else {
							JOptionPane.showMessageDialog(Zlogin, "密码不一致");
						}
					} else {
						JOptionPane.showMessageDialog(Zlogin, "没有此用户名");
					}
				}
				
			}
		});
		
		zhuce.setBackground(new Color(112, 206, 248));
		zhuce.setFont(new Font("宋体", Font.PLAIN, 14));
		//zhuce.setAlignmentX(Component.CENTER_ALIGNMENT);
		zhuce.setForeground(new Color(255, 255, 255));
		Jbutton.add(zhuce);
		
		Jbutton.setBackground(new Color(255, 255, 255));
		login.add(Jbutton);
		
		login.add(Box.createVerticalStrut(30));//添加底部间距
		login.setVisible(true);
		
		zhuce.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Tzhuce();
				
			}
		});
	}
	
	public void Tzhuce()
	{
		Zlogin.setLayout(ZboxLayout);
		Zlogin.setSize(370, 280);
		Zlogin.setLocationRelativeTo(null);
		Zlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Zlogin.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font TextFont=new Font("黑体", Font.BOLD, 16);//建立标题字体
		ZTest.setFont(TextFont);//设置标题字体
		
		Zlogin.add(Box.createVerticalStrut(25));//添加顶部间距
		Zlogin.add(ZTest);//添加标题
		ZTest.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zlogin.add(Box.createVerticalStrut(30));//添加中部间距
		
		ZnameP.setBackground(new Color(255, 255, 255));
		ZnameP.add(ZName);
		ZnameP.add(ZnameT);
		//nameP.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		ZpasswordP.setBackground(new Color(255, 255, 255));
		ZpasswordP.add(ZPassword);
		ZpasswordP.add(ZpasswordT);
		//passwordP.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		ZQpasswordP.setBackground(new Color(255, 255, 255));
		ZQpasswordP.add(ZQPassword);
		ZQpasswordP.add(ZQpasswordT);
		
		
		Zlogin.add(ZnameP);
		Zlogin.add(ZpasswordP);
		Zlogin.add(ZQpasswordP);
		Zlogin.add(Box.createVerticalStrut(40));//添加底部间距
		
		Zqueding.setBackground(new Color(112, 206, 248));
		Zqueding.setFont(new Font("宋体", Font.PLAIN, 14));
		//zhuce.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zqueding.setForeground(new Color(255, 255, 255));
		Zqueding.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Zlogin.add(Zqueding);
		
		Zqueding.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				boolean zhuceYN=true;
				if(ZnameT.getText().equals(""))
				{
					JOptionPane.showMessageDialog(Zlogin, "用户名不得为空");
					zhuceYN=false;
					return;
				}
				if(ZpasswordT.getText().equals(""))
				{
					JOptionPane.showMessageDialog(Zlogin, "密码不得为空");
					zhuceYN=false;
					return;
				}
				if(!(ZpasswordT.getText().equals(ZQpasswordT)))
				{
					JOptionPane.showMessageDialog(Zlogin, "密码不一致");
					zhuceYN=false;
					return;
				}
				if(zhuceYN)
				{
					User one=new User(ZnameT.getText(), ZpasswordT.getText(), "0");
					init.userList.add(one);
					init.UserList_Write_File();
					JOptionPane.showMessageDialog(Zlogin, "注册成功");
					Zlogin.setVisible(false);
				}
				
			}
		});
		
		
		
		Zlogin.add(Box.createVerticalStrut(30));//添加底部间距
		Zlogin.setVisible(true);
	}
	

}
