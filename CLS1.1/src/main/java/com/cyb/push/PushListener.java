package com.cyb.push;

import java.util.Random;


import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class PushListener implements DataListener<Object>{
	SocketIOServer server;
  public PushListener(SocketIOServer server){
  	this.server = server;
  }
	public void onData(SocketIOClient client, Object action, AckRequest req)
			throws Exception {
		System.out.println("有客户主动请求数据，"+action+",client:"+client);
		this.server.getBroadcastOperations().sendEvent("getmsg",new Random().nextInt(255),new Random().nextInt(255));
	}

}