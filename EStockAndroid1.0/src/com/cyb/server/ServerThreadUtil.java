package com.cyb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThreadUtil implements Runnable{
	private Socket client = null;
	public ServerThreadUtil(Socket client){
		this.client = client;
	}
	public void run() {
		try {
			System.out.println("new client connection created!!!");
			readOneStringFromClient();//读取客户端发送的单条消息
			this.client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				this.client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void readOneStringFromClient(){
		PrintStream out;
		try {
			out = new PrintStream(client.getOutputStream());
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			StringBuffer info = new StringBuffer();
			info.append(buf.readLine());
			System.out.println("server msg:"+info.toString());
			out.println(info);
			out.close();
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
