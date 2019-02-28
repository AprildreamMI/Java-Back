package com.sybc.know.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 硕彦博创 许老师
 * 知识问答服务器
 * 【ALT+SHIFT】+J
 * https://pan.baidu.com/s/1lcEf2ZjaInVfrse51gZcVg
 */
public class KnowServer {
		 public static void main(String[] args) {
			 try {
				 //在本地创建了一个服务器
				ServerSocket  ss=new ServerSocket(8888);//ctrl+1
				System.out.println("服务器开启");//sysout
				while(true){
							//接受客户  拿方法的返回值还是使用ctrl+1
							Socket s = ss.accept();//阻塞函数
							//客户 打印
							System.out.println(s);
							//开启一个独立线程（房间）完成会话（项目）
							//ctrl+1(2)
							new Thread(new KnowServerSession(s)).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
