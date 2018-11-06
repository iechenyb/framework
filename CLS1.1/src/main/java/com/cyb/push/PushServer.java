package com.cyb.push;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.fasterxml.jackson.core.JsonProcessingException;

public class PushServer {
// 统计链接的客户端信息
public  static List<SocketIOClient> clients = new ArrayList<SocketIOClient>();
public static SocketIOServer server;
public static boolean isStarted = false;
public void startPushServer() {
	/*try {
		Runtime run = Runtime.getRuntime();   
		String cmdText="kill netstat |grep "+Cons.port;//netstat -aon|findstr 80
		 Process process = run.exec(cmdText);
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	try {
		com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
		config.setHostname("127.0.0.1");
		config.setPort(Cons.port);
		server = new SocketIOServer(config);
		server.start();
		isStarted = true;
		System.out.println("puser server started!");
		PushListener listener = new PushListener(server);
		server.addEventListener("getmsg", Object.class, listener);
	} catch (Exception e) {
		System.out.println("push server start ocurr exception!\n"+e.toString());
	}
}

public static void addListenerToServer() {
	server.addConnectListener(new ConnectListener() {
		public void onConnect(SocketIOClient client) {
			System.out.println("new sessionid=" + client.getSessionId());
			clients.add(client);
		}
	});
}
//为每个创建连接的客户端推送消息
public static void sendToAllClientOneByOne(Map msg)
		throws InterruptedException {
	for (SocketIOClient c : clients) {
		c.sendEvent("pushpoint", msg);
	}
	System.out
			.println("推送消息依次给每个客户端:" + msg + ",链接客户端个数=" + clients.size());
}

public static void sendBroadcast(Map msg) throws InterruptedException {
	server.getBroadcastOperations().sendEvent("pushpoint", msg);
	//System.out.println("推送消息广播:" + msg);
}


public  void  start23232323() throws InterruptedException{
	startPushServer();
	PushListener listener = new PushListener(server);
	server.addEventListener("getmsg", Object.class, listener);
	/*{
	addListenerToServer();
	sendToAllClientOneByOne();
	}*/
	while (true) {
		Random random = new Random();
		Map map = new HashMap();
		map.put("x", random.nextInt(255));
		map.put("y", random.nextInt(255));
		map.put("z", random.nextInt(255));
		//sendToAllClientOneByOne(map);根据链接的客户推送消息
		sendBroadcast(map);//广播推送消息
		Thread.sleep(1000);
	}
	
}

public  void main(String[] args) throws InterruptedException {
	startPushServer();
	JsonProcessingException l;
	PushListener listener = new PushListener(server);
	server.addEventListener("getmsg", Object.class, listener);
	/*{
	addListenerToServer();
	sendToAllClientOneByOne();
	}*/
	while (true) {
		Random random = new Random();
		Map map = new HashMap();
		map.put("x", random.nextInt(255));
		map.put("y", random.nextInt(255));
		map.put("y", random.nextInt(255));
		//sendToAllClientOneByOne(map);根据链接的客户推送消息
		sendBroadcast(map);//广播推送消息
		Thread.sleep(1000);
	}
   }
}

