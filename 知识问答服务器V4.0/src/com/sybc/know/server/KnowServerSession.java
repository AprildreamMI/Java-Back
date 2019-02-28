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

//�����ĻỰ
public class KnowServerSession implements Runnable {
	
	//����һЩ��ͺͶ������
	private  Socket  s;//�ͻ�
	private  BufferedReader  buf;//����
	private  PrintStream   ps;//���

	public KnowServerSession(Socket s) {
		//��ʼ������
		//���ǲ���IO����������쳣(catch��  Exception �����쳣)
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
			����IO����static�� ȥ���������ļ�����session.java����ͣ���ʼ��
	 */
	private  static  Properties  users=new Properties();
	private  static  Properties  works=new Properties();
	
	static{
			//���������ļ�
			InputStream  is=null;
				try {
					is=new FileInputStream("users.properties");
					users.load(is);
					
					is=new FileInputStream("works.properties");
					works.load(is);
					
					//�ر�
					is.close();
					
					//����
					System.out.println(users.getProperty("admin"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	
	
	
	public void run() {
		GUI();
	}
	/*
	 * GUI:���ǰ�������չʾ ����
	 */	
	private void GUI() {
		//�������PS���ͻ�˵
		ps.println("*��ӭ����˶���֪ʶ�ʴ𻷽�,��ѡ��1/2/3/4**");
		ps.println("**************1.��ͨ�û�ע��************");
		ps.println("**************2.��ͨ�û���¼************");
		ps.println("**************3.����Ա��¼**************");
		ps.println("**************4.�˳�*******************");
		
		try {
			//��ȡ�ͻ���Ϣ ����ɸѡ �ж�
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
				//����Ĳ��Ϸ�
				ps.println("������Ĳ��Ϸ�,������1/2/3/4");
				//�ٴλش� ѡ�����
				GUI();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * ����ģ��4���˳�
	 */
	private void Quit() {
		// TODO Auto-generated method stub
		try {
			ps.println("��ӭ�´�����������");
			ps.close();
			buf.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ����Ա���⣺һ�㶼��ȥ�����㷨��Base64��JavaProject�� �����㷨(WebProject)��
	 */
	private void AdminLogin() {
		// TODO Auto-generated method stub
		//�Լ���ɹ���Ա��¼��֤...
		ps.println("����Ա���Ƿ���Ҫ���⡾Y��/��N��");
		try {
			String  line=null;
			while((line=buf.readLine()).equalsIgnoreCase("y")){
				ps.println("�������Ŀ:");
				String  tm=buf.readLine();
				ps.println("�����"+tm+"��Ӧ�Ĵ�");
				String  pw=buf.readLine();
				
				//����Ŀ�ʹ𰸴洢��works.properties
				OutputStream  os=new FileOutputStream("works.properties");
				works.setProperty(tm, pw);
				works.store(os, null);
				os.close();
				
				Thread.sleep(2000);
				
				ps.println("�洢�ɹ�,���Ƿ���Ҫ���⡾Y��/��N��");
			}
			
			ps.println("������ϣ�����������");
			GUI();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 *  �����û���¼ ��ɴ��⻷��
	 */
	private void NormalLogin() {
		try {
			//��ʾ��¼�Ĵ���
			int  i=0;
			while(i<3){
				ps.println("�����������˻�:");
				//���ܿͻ��������Ϣ
				String  uname=buf.readLine();
				ps.println("������"+uname+",��Ӧ������");
				//���ܿͻ����������
				String upass=buf.readLine();
				Test();
				//�ж�
				if(upass.equals(users.getProperty(uname))){
					 ps.println("��¼�ɹ�,�������ڳ���Ŀ");
					 //�ֶ�������ⷽ��
					 chuTi();
				}else{
					 ps.println("��¼ʧ��"+(i+1));
					 if(i == 2){
						 ps.println("�����ε�¼ʧ��");
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
	 * ��works.properties(�����ļ�) ������ó�5�⣬չʾ���ͻ������棬���д���
	 * 
	 */
	private void chuTi() {
		try {
			//System.out.println("come here");
			//�õ����е���Ŀ
			Set<Object> keySet = works.keySet();
			//keySetת������
			Object[] arrays = keySet.toArray();
			//�����
			Random  r=new  Random();
			//��Ŀ�ĸ���
			int length = keySet.size();
			//�洢�����5����Ŀ�ļ���
			Set<String>  set=new HashSet<String>();
			while(set.size()<5){//<=5
				//�����Ŀ�ı��
				int  n=r.nextInt(length);
				set.add((String)arrays[n]);
			}
			//[1+1, Java֮��, Java��ͨ��socket�ǿͻ��˻��Ƿ�����Y/N, Java�Ļ�������web������Y/N, 1-1]
			System.out.println(set);
			//���������ȥ��ʾ��������һ��
			int  index=1;
			//�洢����
			int  score=0;
			//�����ϵ�����һ��һ��չʾ���ͻ����ͻ����δ���
			Iterator<String> its = set.iterator();
			while(its.hasNext()){//�������һ������
					String timu = its.next();//ȡ��ÿһ����Ŀ
					//��timuչʾ���ͻ���
					ps.println("��"+index+"��Ŀ:"+timu);
					//���ܿͻ�����Ĵ�
					String answer=buf.readLine();
					Test();
					if(answer.equals(works.getProperty(timu))){
						ps.println("��ϲ�㣬����˼�20��");
						score+=20;
					}else{
						ps.println("�����,��ȷ�Ĵ���:"+works.getProperty(timu));
					}
					index++;
			}
			Test();
			ps.println("������ϣ���������ȷ����:"+score+"%");
			GUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ����1����ͨ�û�ע��
	 */
	private void NormalRegist() {
		// TODO Auto-generated method stub
		try {
			//ע���˻�
			ps.println("������ע���˻�:");
			String uname=buf.readLine();//����ΰ

			//ע������
			ps.println("��������˺�"+uname+",��Ӧ����:");
			String upass=buf.readLine();
			
			//�ٴ�ȷ������
			ps.println("���ٴ�������˺�"+uname+",��Ӧ����:");
			String upass2=buf.readLine();
			
			Test();
			
			//�����ж�
			if(upass.equals(upass2)){
					//OK
					ps.println("ע��ɹ�!!!!");
					//���˻�������洢��users.properties
					OutputStream  os=new FileOutputStream("users.properties");
					users.setProperty(uname, upass);
					users.store(os, null);
					os.close();
			}else{
					//ERROR
					ps.println("ע��ʧ��!!!!");
			}
			
			//�ٴλص� ѡ�����
			Thread.sleep(2000);
			GUI();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void Test() throws InterruptedException {
		ps.println("�������ڼ����");
		for(int i=0;i<3;i++){
			Thread.sleep(100);
			ps.print(".");
		}
		ps.println("");
	}	
}
