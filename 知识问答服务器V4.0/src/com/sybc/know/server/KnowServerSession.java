package com.sybc.know.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

//单独的会话
public class KnowServerSession implements Runnable {
	
	//声明一些嘴巴和耳朵变量
	private  Socket  s;//客户
	private  BufferedReader  buf;//耳朵
	private  PrintStream   ps;//嘴巴

	public KnowServerSession(Socket s) {
		//初始化变量
		//凡是操作IO流都会出现异常(catch块  Exception 顶级异常)
		try {
			//ERROR:s=this.s;
			this.s=s;
			buf=new BufferedReader(new InputStreamReader(s.getInputStream()));
			ps=new PrintStream(s.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/*
			利用IO流和static块 去加载属性文件，当session.java编译就（开始）
	 */
	private  static  Properties  users=new Properties();
	private  static  Properties  works=new Properties();
	
	static{
			//关联属性文件
			InputStream  is=null;
				try {
					is=new FileInputStream("users.properties");
					users.load(is);
					
					is=new FileInputStream("works.properties");
					works.load(is);
					
					//关闭
					is.close();
					
					//测试
					System.out.println(users.getProperty("admin"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	
	
	
	public void run() {
		GUI();
	}
	/*
	 * GUI:就是帮助我们展示 需求
	 */	
	private void GUI() {
		//利用嘴巴PS给客户说
		ps.println("*欢迎来到硕彦的知识问答环节,请选择1/2/3/4**");
		ps.println("**************1.普通用户注册************");
		ps.println("**************2.普通用户登录************");
		ps.println("**************3.管理员登录**************");
		ps.println("**************4.退出*******************");
		
		try {
			//读取客户信息 进行筛选 判断
			String  line=buf.readLine();
			if(line.equals("1")){
				NormalRegist();
			}else if(line.equals("2")){
				NormalLogin();
			}else if(line.equals("3")){
				AdminLogin();
			}else if(line.equals("4")){
				Quit();
			}else{
				Test();
				//输入的不合法
				ps.println("您输入的不合法,请输入1/2/3/4");
				//再次回答 选择界面
				GUI();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 功能模块4：退出
	 */
	private void Quit() {
		// TODO Auto-generated method stub
		try {
			ps.println("欢迎下次再来！！！");
			ps.close();
			buf.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 管理员出题：一般都会去加入算法（Base64（JavaProject） 电梯算法(WebProject)）
	 */
	private void AdminLogin() {
		// TODO Auto-generated method stub
		//自己完成管理员登录验证...
		ps.println("管理员您是否需要出题【Y】/【N】");
		try {
			String  line=null;
			while((line=buf.readLine()).equalsIgnoreCase("y")){
				ps.println("请给出题目:");
				String  tm=buf.readLine();
				ps.println("请给出"+tm+"对应的答案");
				String  pw=buf.readLine();
				
				//将题目和答案存储到works.properties
				OutputStream  os=new FileOutputStream("works.properties");
				works.setProperty(tm, pw);
				works.store(os, null);
				os.close();
				
				Thread.sleep(2000);
				
				ps.println("存储成功,您是否还需要出题【Y】/【N】");
			}
			
			ps.println("出题完毕！，您辛苦了");
			GUI();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 *  处理用户登录 完成答题环节
	 */
	private void NormalLogin() {
		try {
			//表示登录的次数
			int  i=0;
			while(i<3){
				ps.println("请输入您的账户:");
				//接受客户输入的信息
				String  uname=buf.readLine();
				ps.println("请输入"+uname+",对应的密码");
				//接受客户输入的密码
				String upass=buf.readLine();
				Test();
				//判断
				if(upass.equals(users.getProperty(uname))){
					 ps.println("登录成功,电脑正在出题目");
					 //手动补齐出题方法
					 chuTi();
				}else{
					 ps.println("登录失败"+(i+1));
					 if(i == 2){
						 ps.println("第三次登录失败");
						 break;
					 }
				}
				i++;
			}
			GUI();
			
		} catch (Exception e) {
		}
	}
	/*
	 * 从works.properties(属性文件) 中随机拿出5题，展示到客户端上面，进行答题
	 * 
	 */
	private void chuTi() {
		try {
			//System.out.println("come here");
			//拿到所有的题目
			Set<Object> keySet = works.keySet();
			//keySet转成数组
			Object[] arrays = keySet.toArray();
			//随机类
			Random  r=new  Random();
			//题目的个数
			int length = keySet.size();
			//存储随机的5个题目的集合
			Set<String>  set=new HashSet<String>();
			while(set.size()<5){//<=5
				//随机题目的标号
				int  n=r.nextInt(length);
				set.add((String)arrays[n]);
			}
			//[1+1, Java之父, Java的通信socket是客户端还是服务器Y/N, Java的基础包括web开放吗Y/N, 1-1]
			System.out.println(set);
			//定义变量：去表示当下是哪一题
			int  index=1;
			//存储分数
			int  score=0;
			//将集合的数据一个一个展示给客户，客户依次答题
			Iterator<String> its = set.iterator();
			while(its.hasNext()){//如果有下一个数据
					String timu = its.next();//取出每一个题目
					//将timu展示给客户端
					ps.println("第"+index+"题目:"+timu);
					//接受客户输入的答案
					String answer=buf.readLine();
					Test();
					if(answer.equals(works.getProperty(timu))){
						ps.println("恭喜你，答对了加20分");
						score+=20;
					}else{
						ps.println("答错了,正确的答案是:"+works.getProperty(timu));
					}
					index++;
			}
			Test();
			ps.println("答题完毕！，您的正确率是:"+score+"%");
			GUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 功能1：普通用户注册
	 */
	private void NormalRegist() {
		// TODO Auto-generated method stub
		try {
			//注册账户
			ps.println("请输入注册账户:");
			String uname=buf.readLine();//姜东伟

			//注册密码
			ps.println("请输入该账号"+uname+",对应密码:");
			String upass=buf.readLine();
			
			//再次确认密码
			ps.println("请再次输入该账号"+uname+",对应密码:");
			String upass2=buf.readLine();
			
			Test();
			
			//密码判断
			if(upass.equals(upass2)){
					//OK
					ps.println("注册成功!!!!");
					//将账户和密码存储到users.properties
					OutputStream  os=new FileOutputStream("users.properties");
					users.setProperty(uname, upass);
					users.store(os, null);
					os.close();
			}else{
					//ERROR
					ps.println("注册失败!!!!");
			}
			
			//再次回到 选择界面
			Thread.sleep(2000);
			GUI();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void Test() throws InterruptedException {
		ps.println("电脑正在检测中");
		for(int i=0;i<3;i++){
			Thread.sleep(100);
			ps.print(".");
		}
		ps.println("");
	}	
}
