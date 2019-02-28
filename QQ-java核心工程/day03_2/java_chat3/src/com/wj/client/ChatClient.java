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
 * ��J�İ汾�Ȳ���J�İ汾��
 */
public class ChatClient extends  JFrame{
		//Ĭ�ϵĲ����Ǳ߽粼��.(���еĿؼ�Ĭ�����м�)

		//���������չʾ��
		TextArea  ta=new TextArea();
		//��������������
		JTextField jtf=new JTextField();
		private DataOutputStream dos;  //д����
		private DataInputStream dis;  //��ȡ��
		public ChatClient(){
			//���ؼ�����ָ����λ��
			this.add(ta,BorderLayout.CENTER);//BorderLayout���߽粼��
			this.add(jtf,BorderLayout.SOUTH);
			//���ô�С
			this.setSize(400, 300);//�� ��
			//���ñ���
			this.setTitle("�人��ͨjava_chat_client");
			//�رպ�̨����Operation����
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//��ʾ����
			this.setVisible(true);
			//ʵ�ּ��̼���:Listener�϶��ǽӿ�
			//Action:ʵ��Ĭ�ϵĻس��¼�����
			jtf.addActionListener(new MyListener());
			//ʵ�ֽ�����socket
			Connection();
			//�����߳̽��������ת�����ͻ���readUTF()���������� 
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
						ta.setText(ta.getText()+"\n"+time+"\n"+content+"\n");  //����������ı���Ϊԭ�������ݼ���ʱ���ټ��Ϸ��������͹���������
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
		 * ���Ӻ�̨�ķ���
		 * http://www.baidu.com(http://202.108.22.5:80)  ����:n��ip+1���˿�(0~65535)
		 * http(s) port:80
		 * java_web_tomcat 8080
		 * ���ʼ�:smtp    25
		 *  tftp  �ϴ�������  21
		 *  localhost:127.0.0.1û�о���·������IP
		 *  
		 */
		private void Connection() {
			try {
				//����1:IP��ַ  ����2:�˿ں�
				Socket  s=new Socket("localhost",8888); //����ʵ�ֿͻ����׽��֣�Ҳ���ԾͽС��׽��֡������׽�������̨������ͨ�ŵĶ˵㡣 
				System.out.println("a client is created");
				//�����OUT ���
				//�ֽ���
				OutputStream os = s.getOutputStream();  //���յ��˷�������д����
				//�ַ���
				dos = new DataOutputStream(os);  //ֱ�Ӹ����ͻ��˵�д����
				
				//����
				dis = new DataInputStream(s.getInputStream());  //��ȡ�������Ķ�ȡ��
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//�ڲ���(Android Studio���ִ�Сд��ʾ��)
		//����:ȫ��ʹ��ctrl+1
		//ctrl+s(save)����
		private class  MyListener implements ActionListener{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//1.��ȡjtf������
				//��ȥ�����ķ���ֵ Ҳ��ctrl+1
				String content = jtf.getText();
				//2.�����ݸ�ta
                //ta.setText(content);
				//3.���jtf������
				jtf.setText(null);
				
				//���������dos��ͽ����� �͸� ������
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
