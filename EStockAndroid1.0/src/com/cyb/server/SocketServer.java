package com.cyb.server;

import java.io.IOException;
import java.net.ServerSocket;
/**
 * socketͨѶ
 * @author DHUser
 *
 */
public class SocketServer {
	public static ServerSocket  server = null;
	public static boolean isStart =false ;//�߳��Ƿ�����
	public static void main(String[] args) {
		SocketServer.start();
	}

	public static void start() {
		try {
			server = new ServerSocket(8888);
			server.setSoTimeout(2000);
			isStart = true;
			System.out.println("����������ϣ�");
			/*while (true) {
				if(server==null){
					System.out.println("���񱻹رգ�");
					break;
				}
				new Thread(new ServerThreadUtil(server.accept())).start();
			}*/
			//���ȱ��1 �����³�������һֱ�ȴ��������̵߳�������
			new Thread(
			new  Runnable() {
				public void run() {
					while (isStart) {
						if(server==null){
							System.out.println("���񱻹رգ�");
							break;
						}
						try {
							new Thread(new ServerThreadUtil(server.accept())).start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();//���ȱ��2�������ȱ��1����Ч����ͬ����������󣬳�������һֱ�ȴ���
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void stop() {
		try {
			if(server!=null){
				server.close();
			}
			server = null;
			isStart = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
