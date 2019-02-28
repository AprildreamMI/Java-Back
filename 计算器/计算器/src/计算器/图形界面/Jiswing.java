package 计算器.图形界面;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Jiswing 
{
	JFrame mainSwing=new JFrame("计算器");
	JPanel Xianshi=new JPanel();
	JPanel jianpan=new JPanel();
	JButton jianButton[]=new JButton[24];
	JLabel xianshiJ=new JLabel("0");//设置一个标签为计算结果
	
	String[] jian={"%","√","x²","¹/x","CE","C","←","÷","7","8","9","×","4","5","6","－","1","2","3","＋","±","0",".","＝"};

	double ZhongJ=0.0;
	boolean Shouxie=true;
	boolean Shuchu=true;
	String Yunsuan="＝";
	
	public void init()
	{
		Xianshi.setLayout(new BoxLayout(Xianshi, BoxLayout.Y_AXIS));//定义显示面板为Box布局管理器，并上下摆放
		mainSwing.add(Xianshi,NORTH);//添加显示面板到主面板中去
		
		//mainSwing.setLayout(new BoxLayout(mainSwing, BoxLayout.Y_AXIS));
		mainSwing.setSize(330, 540);//主面板大小
		mainSwing.setLocationRelativeTo(null);//位置居中
		mainSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//可以关闭
		Color Mbackground=new Color(224,224,224);//设定颜色值
		Xianshi.setBackground(Mbackground);
		jianpan.setBackground(Mbackground);
		
		Font font=new Font("Microsoft Yahei",Font.BOLD,16);
		Font font1=new Font("宋体", Font.BOLD, 40);//设置一个字体标准
		
		
		
		
		xianshiJ.setFont(font1);//设定字体
		
		
		Xianshi.add(Box.createVerticalStrut(10));//设置垂直之间的间距
		
		Xianshi.add(Box.createVerticalStrut(75));//设置垂直之间的间距标准和计算结果
	
		xianshiJ.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Xianshi.add(xianshiJ);//添加结果集到水平Box面板
		Xianshi.add(Box.createHorizontalStrut(2));//靠右边编剧距离
		
		Xianshi.add(Box.createVerticalStrut(45));
		
		jianpan.setLayout(new GridLayout(6,4,4,4));
		mainSwing.add(jianpan);
		
		for(int i=0;i<jian.length;i++)
		{
			jianButton[i]=new JButton(jian[i]);
			jianButton[i].setBackground(new Color(244, 244, 244));
			jianButton[i].setFont(font);
			jianButton[i].addActionListener(new OkListener());
			jianpan.add(jianButton[i]);
		}
		
		for(int i=8;i<19;i++)
		{
			if(i==11||i==15)
			{
				continue;
			}
			jianButton[i].setBackground(new Color(253, 253, 253));
		}
		mainSwing.setVisible(true);//可以显示
	}
	
	class OkListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String shijianW=e.getActionCommand();
			switch (shijianW) 
			{
			    case "1":anShu(shijianW);break;
			    case "2":anShu(shijianW);break;
			    case "3":anShu(shijianW);break;
			    case "4":anShu(shijianW);break;
			    case "5":anShu(shijianW);break;
			    case "6":anShu(shijianW);break;
			    case "7":anShu(shijianW);break;
			    case "8":anShu(shijianW);break;
			    case "9":anShu(shijianW);break;
			    case "0":anShu(shijianW);break;
			    case ".":anShu(shijianW);break;
			    
			    case "C":anC();break;
			    case "CE":xianshiJ.setText("0");break;
			    case "←":anB();break;
			    
			    case "%":anYun(shijianW);break;
			    case "√":anYun(shijianW);break;
			    case "x²":anYun(shijianW);break;
			    case "¹/x":anYun(shijianW);break;
			    case "÷":anYun(shijianW);break;
			    case "×":anYun(shijianW);break;
			    case "－":anYun(shijianW);break;
			    case "＋":anYun(shijianW);break;
			    case "±":anYun(shijianW);break;
			    case "＝":anYun(shijianW);break;
			}
			
		}
		
	}
	
	public void anB()//按下了退格键
	{
		String text=xianshiJ.getText();
		int textlen=text.length();
		if(text.substring(0, textlen-1).length()==0)
		{
			anC();
		}
		else {
			xianshiJ.setText(text.substring(0, textlen-1));
		}
		
	}
	
	public void anC() //按下了C键
	{
		xianshiJ.setText("0");
		ZhongJ=0.0;
		Shouxie=true;
		Yunsuan="＝";
	}
	
	public void anShu(String Skey)//按下数字键
	{
		if (Shouxie)//是否是第一个数字
		{
			xianshiJ.setText(Skey);
		}
		else if(Skey.equals(".")&&xianshiJ.getText().indexOf(".")<0)
		{
			xianshiJ.setText(xianshiJ.getText()+".");
		}
		else if (!Skey.equals("."))
		{
			xianshiJ.setText(xianshiJ.getText()+Skey);
		}
		
		Shouxie=false;
	}
	
	public void anYun(String Ykey) 
	{
		if (Yunsuan.equals("%")) 
		{
			ZhongJ=ZhongJ/100;
		}
		else if (Yunsuan.equals("√")) 
		{
			ZhongJ=Math.sqrt(ZhongJ);
		}
		else if (Yunsuan.equals("x²")) 
		{
			ZhongJ=ZhongJ*ZhongJ;
		}
		else if (Yunsuan.equals("¹/x")) 
		{
			if (ZhuanHuan()!=0)
			{
				ZhongJ=1/ZhongJ;
			}
			else
			{
				Shuchu=false;
				xianshiJ.setText("分母不能为0");
			}
		}
		else if (Yunsuan.equals("÷")) 
		{
			if (ZhuanHuan()!=0)
			{
				ZhongJ/=ZhuanHuan();
			}
			else
			{
				Shuchu=false;
				xianshiJ.setText("分母不能为0");
			}
		}
		else if (Yunsuan.equals("×")) 
		{
			ZhongJ*=ZhuanHuan();
		}
		else if (Yunsuan.equals("-"))
		{
			ZhongJ-=ZhuanHuan();
		}
		else if (Yunsuan.equals("＋"))
		{
			ZhongJ+=ZhuanHuan();
		}
		else if (Yunsuan.equals("±"))
		{
			ZhongJ=-ZhongJ;
		}
		else if (Yunsuan.equals("＝"))
		{
			ZhongJ=ZhuanHuan();
		}
		
		if (Shuchu)
		 {
			long t1;
			double t2;
			t1=(long)ZhongJ;
			t2=ZhongJ-t1;
			if(t2==0)
			{
				xianshiJ.setText(String.valueOf(t1));
			}
			else {
				xianshiJ.setText(String.valueOf(ZhongJ));
			}
		 }
		
		Shouxie=true;
		Yunsuan=Ykey;
		Shuchu= true;
	}
	
	public double ZhuanHuan()
	{
		double ZhuanZ;
		ZhuanZ=Double.parseDouble(xianshiJ.getText());
		return ZhuanZ;
	}
	
	
	public static void main(String[] args) 
	{
		Jiswing one=new Jiswing();
		one.init();
	}
}
