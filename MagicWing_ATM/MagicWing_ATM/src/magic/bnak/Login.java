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
	
	
	JFrame login=new JFrame("�û���¼");
	
	Box NamePassword=Box.createVerticalBox();
	
	JPanel nameP=new JPanel();
	JPanel passwordP=new JPanel();
	JPanel Jbutton=new JPanel();
	
	BoxLayout boxLayout=new BoxLayout(login.getContentPane(), BoxLayout.Y_AXIS);
	
	JLabel Test=new JLabel("M W �� �� �� ��");
	JLabel Name= new JLabel("�û���:");
	JLabel Password=new JLabel("��    ��:");
	
	TextField nameT=new TextField(20);
	TextField passwordT=new TextField(20);
	
	JButton log=new JButton("�� ¼");
	JButton zhuce=new JButton("ע ��");
	
	
	
    JFrame Zlogin=new JFrame("�û�ע��");
	
	
	JPanel ZnameP=new JPanel();
	JPanel ZpasswordP=new JPanel();
	JPanel ZQpasswordP=new JPanel();
	
	BoxLayout ZboxLayout=new BoxLayout(Zlogin.getContentPane(), BoxLayout.Y_AXIS);
	
	JLabel ZTest=new JLabel("ע   ��");
	JLabel ZName= new JLabel("�û���:");
	JLabel ZPassword=new JLabel("��    ��:");
	JLabel ZQPassword=new JLabel("ȷ������:");
	
	TextField ZnameT=new TextField(20);
	TextField ZpasswordT=new TextField(20);
	TextField ZQpasswordT=new TextField(20);
	
	JButton Zqueding=new JButton("ȷ��");
	
	
	
	public Login()
	{
		login.setLayout(boxLayout);
		login.setSize(385, 295);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setBackground(new Color(255, 255, 255));
		
		Font TextFont=new Font("����", Font.BOLD, 16);//������������
		Test.setFont(TextFont);//���ñ�������
		
		login.add(Box.createVerticalStrut(25));//��Ӷ������
		login.add(Test);//��ӱ���
		Test.setAlignmentX(Component.CENTER_ALIGNMENT);
		login.add(Box.createVerticalStrut(30));//����в����
		
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
		login.add(Box.createVerticalStrut(40));//��ӵײ����
		
		log.setBackground(new Color(112, 206, 248));
		log.setFont(new Font("����", Font.PLAIN, 14));
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
							init.recordString=new StringBuilder();//��գ����⽫��һ���û��ļ�¼д���µ�¼���û���
							
							//������ǰ�û��ļ�
							File userFile=new File(init.currentUser.getID()+".text");
							if(!(userFile.exists()))
							{
								try {
									userFile.createNewFile();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showInternalMessageDialog(login, "�����û��ļ�ʧ��");
								}
							}
							init.userFile=userFile;
							
							
							//��ȡ��ǰ�û���¼�ļ�
							try {
								currentUserReader=new FileReader(init.userFile);
								
							} catch (FileNotFoundException e1) {
								JOptionPane.showInternalMessageDialog(login, "��ȡ��ǰ�û���¼�ļ�ʧ��");
							}
							
							BufferedReader uBufferedReader=new BufferedReader(currentUserReader);
							
							String tem="";
							try {
								while ((tem=uBufferedReader.readLine())!=null) 
								{
									init.recordString.append(tem);//��ȡԭ�ȸ��˻��ļ�¼��ÿһ�в�ƴ�ӵ�Test.recordString�У���inqury���������Ϊ��ѯ��¼�Ľ��
									
								}
							} catch (IOException e1) {
								JOptionPane.showInternalMessageDialog(login, "ƴ�ӵ�ǰ�û��ļ���¼ʧ��");
							}
							
							
							Menu menu=new Menu();
							login.setVisible(false);
							
						} else {
							JOptionPane.showMessageDialog(Zlogin, "���벻һ��");
						}
					} else {
						JOptionPane.showMessageDialog(Zlogin, "û�д��û���");
					}
				}
				
			}
		});
		
		zhuce.setBackground(new Color(112, 206, 248));
		zhuce.setFont(new Font("����", Font.PLAIN, 14));
		//zhuce.setAlignmentX(Component.CENTER_ALIGNMENT);
		zhuce.setForeground(new Color(255, 255, 255));
		Jbutton.add(zhuce);
		
		Jbutton.setBackground(new Color(255, 255, 255));
		login.add(Jbutton);
		
		login.add(Box.createVerticalStrut(30));//��ӵײ����
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
		
		Font TextFont=new Font("����", Font.BOLD, 16);//������������
		ZTest.setFont(TextFont);//���ñ�������
		
		Zlogin.add(Box.createVerticalStrut(25));//��Ӷ������
		Zlogin.add(ZTest);//��ӱ���
		ZTest.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zlogin.add(Box.createVerticalStrut(30));//����в����
		
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
		Zlogin.add(Box.createVerticalStrut(40));//��ӵײ����
		
		Zqueding.setBackground(new Color(112, 206, 248));
		Zqueding.setFont(new Font("����", Font.PLAIN, 14));
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
					JOptionPane.showMessageDialog(Zlogin, "�û�������Ϊ��");
					zhuceYN=false;
					return;
				}
				if(ZpasswordT.getText().equals(""))
				{
					JOptionPane.showMessageDialog(Zlogin, "���벻��Ϊ��");
					zhuceYN=false;
					return;
				}
				if(!(ZpasswordT.getText().equals(ZQpasswordT)))
				{
					JOptionPane.showMessageDialog(Zlogin, "���벻һ��");
					zhuceYN=false;
					return;
				}
				if(zhuceYN)
				{
					User one=new User(ZnameT.getText(), ZpasswordT.getText(), "0");
					init.userList.add(one);
					init.UserList_Write_File();
					JOptionPane.showMessageDialog(Zlogin, "ע��ɹ�");
					Zlogin.setVisible(false);
				}
				
			}
		});
		
		
		
		Zlogin.add(Box.createVerticalStrut(30));//��ӵײ����
		Zlogin.setVisible(true);
	}
	

}
