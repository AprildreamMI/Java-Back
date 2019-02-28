package com.wj.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
		//���弯��
		static List<Client>  clients=new  ArrayList<Client>();
	
		//���ɴ�����
		public static void main(String[] args) {
			//��δServerSocket
			try {
				ServerSocket  ss = new ServerSocket(8888);//����
				System.out.println("java_project����������");//�人
				//���ܿͻ�����
				while(true){//�佻
					Socket s = ss.accept();//accept:���� �е��ʵ�       //��Ҫһֱ���ܣ�������һ��ѭ������
					System.out.println(s);
					//���ܿͻ��˵�����
					Client  client = new  Client(s);
					//�������߳�
					new Thread(client).start();//start()--->run()     //ÿ������һ���ͻ��˶�Ҫ��������һ������������
					
					clients.add(client);    //����ӵ�һ��������
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//�ڲ���:(��������Ա���ֲ�����̬)
		//ʵ�ֶ��̵߳ķ�ʽ
		private static class  Client  implements  Runnable{
			Socket  s;
			private DataInputStream dis;
			private DataOutputStream dos;
			public Client(Socket s) {
				this.s=s;
				try {
					dis = new  DataInputStream(s.getInputStream());
					dos=new DataOutputStream(s.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			/*
					ת��:
					������������ ˵�����пͻ���  out	
			 */
			
			public  void  send(String content){
				try {
					dos.writeUTF(content);
				} catch (IOException e) {
					try {
						dos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			public void run() {
				 while(true){
					 try {
						 String content = dis.readUTF();//��������
						 System.out.println("���ܿͻ��˵�����---->"+content);
						 
						 //����ת��
						 for(Client  item:clients){
							  item.send(content);
						 }
						 
					} catch (Exception e) {
						try {
							dis.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				 }
			}
			
		}
		
		
		
}
