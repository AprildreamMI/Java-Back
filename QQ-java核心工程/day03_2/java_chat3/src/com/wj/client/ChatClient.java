package com.wj.client;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;

/*import com.sun.corba.se.pept.transport.Connection;*/

/**
 * @author wolves
 * 带J的版本比不带J的版本高
 */
public class ChatClient extends  JFrame{
		//默认的布局是边界布局.(所有的控件默认在中间)

		//定义上面的展示框
		TextArea  ta=new TextArea();
		//定义下面的输入框
		JTextField jtf=new JTextField();
		private DataOutputStream dos;  //写入流
		private DataInputStream dis;  //读取流
		public ChatClient(){
			//将控件放在指定的位置
			this.add(ta,BorderLayout.CENTER);//BorderLayout：边界布局
			this.add(jtf,BorderLayout.SOUTH);
			//设置大小
			this.setSize(400, 300);//宽 高
			//设置标题
			this.setTitle("武汉交通java_chat_client");
			//关闭后台进程Operation操作
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//显示界面
			this.setVisible(true);
			//实现键盘监听:Listener肯定是接口
			//Action:实现默认的回车事件监听
			jtf.addActionListener(new MyListener());
			//实现界面变成socket
			Connection();
			//开启线程解决服务器转发给客户端readUTF()的阻塞问题 
			MyReceiver  m=new MyReceiver();
			new Thread(m).start();
		}
		
		private  class  MyReceiver  implements  Runnable{

			public void run() {
				while(true){
					 try {
						String content = dis.readUTF();
						Date  date=new Date();
						SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
						String time = sdf.format(date);
						ta.setText(ta.getText()+"\n"+time+"\n"+content+"\n");  //设置上面的文本框为原来的内容加上时间再加上服务器发送过来的内容
					} catch (IOException e) {
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
		
		/**
		 * 连接后台的方法
		 * http://www.baidu.com(http://202.108.22.5:80)  域名:n个ip+1个端口(0~65535)
		 * http(s) port:80
		 * java_web_tomcat 8080
		 * 发邮件:smtp    25
		 *  tftp  上传和下载  21
		 *  localhost:127.0.0.1没有经过路由器的IP
		 *  
		 */
		private void Connection() {
			try {
				//参数1:IP地址  参数2:端口号
				Socket  s=new Socket("localhost",8888); //此类实现客户端套接字（也可以就叫“套接字”）。套接字是两台机器间通信的端点。 
				System.out.println("a client is created");
				//输出流OUT 嘴巴
				//字节流
				OutputStream os = s.getOutputStream();  //接收到了服务器的写入流
				//字符流
				dos = new DataOutputStream(os);  //直接给到客户端的写入流
				
				//耳朵
				dis = new DataInputStream(s.getInputStream());  //获取服务器的读取流
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//内部类(Android Studio区分大小写提示的)
		//爆红:全部使用ctrl+1
		//ctrl+s(save)保持
		private class  MyListener implements ActionListener{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//1.获取jtf的内容
				//拿去方法的返回值 也是ctrl+1
				String content = jtf.getText();
				//2.将内容给ta
                //ta.setText(content);
				//3.清空jtf的内容
				jtf.setText(null);
				
				//利用上面的dos嘴巴将内容 送给 服务器
				try {
					dos.writeUTF(content);
				} catch (IOException e) {
					try {
						dos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}
		
		
		
		
		public static void main(String[] args) {
			new ChatClient();
		}
}
