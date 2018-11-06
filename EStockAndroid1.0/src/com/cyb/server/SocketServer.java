package com.cyb.server;

import java.io.IOException;
import java.net.ServerSocket;
/**
 * socket通讯
 * @author DHUser
 *
 */
public class SocketServer {
	public static ServerSocket  server = null;
	public static boolean isStart =false ;//线程是否启动
	public static void main(String[] args) {
		SocketServer.start();
	}

	public static void start() {
		try {
			server = new ServerSocket(8888);
			server.setSoTimeout(2000);
			isStart = true;
			System.out.println("服务启动完毕！");
			/*while (true) {
				if(server==null){
					System.out.println("服务被关闭！");
					break;
				}
				new Thread(new ServerThreadUtil(server.accept())).start();
			}*/
			//设计缺陷1 ，导致程序卡死，一直等待，需用线程单独启动
			new Thread(
			new  Runnable() {
				public void run() {
					while (isStart) {
						if(server==null){
							System.out.println("服务被关闭！");
							break;
						}
						try {
							new Thread(new ServerThreadUtil(server.accept())).start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();//设计缺陷2：与设计缺陷1运行效果相同，启动服务后，程序卡死，一直等待。
			
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
