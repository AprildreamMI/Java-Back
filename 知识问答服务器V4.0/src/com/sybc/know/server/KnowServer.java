package com.sybc.know.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ˶�岩�� ����ʦ
 * ֪ʶ�ʴ������
 * ��ALT+SHIFT��+J
 * https://pan.baidu.com/s/1lcEf2ZjaInVfrse51gZcVg
 */
public class KnowServer {
		 public static void main(String[] args) {
			 try {
				 //�ڱ��ش�����һ��������
				ServerSocket  ss=new ServerSocket(8888);//ctrl+1
				System.out.println("����������");//sysout
				while(true){
							//���ܿͻ�  �÷����ķ���ֵ����ʹ��ctrl+1
							Socket s = ss.accept();//��������
							//�ͻ� ��ӡ
							System.out.println(s);
							//����һ�������̣߳����䣩��ɻỰ����Ŀ��
							//ctrl+1(2)
							new Thread(new KnowServerSession(s)).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
