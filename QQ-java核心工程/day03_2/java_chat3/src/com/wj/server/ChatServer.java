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
		//定义集合
		static List<Client>  clients=new  ArrayList<Client>();
	
		//集成大数据
		public static void main(String[] args) {
			//如何搭建ServerSocket
			try {
				ServerSocket  ss = new ServerSocket(8888);//北京
				System.out.println("java_project服务器开启");//武汉
				//接受客户上线
				while(true){//武交
					Socket s = ss.accept();//accept:接受 有道词典       //还要一直接受，所以在一个循环里面
					System.out.println(s);
					//接受客户端的数据
					Client  client = new  Client(s);
					//开启多线程
					new Thread(client).start();//start()--->run()     //每次上线一个客户端都要单独给开一个进程来管理
					
					clients.add(client);    //并添加到一个集合中
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//内部类:(匿名、成员、局部、静态)
		//实现多线程的方式
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
					转发:
					服务器将内容 说给所有客户端  out	
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
						 String content = dis.readUTF();//阻塞函数
						 System.out.println("接受客户端的数据---->"+content);
						 
						 //立刻转发
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
