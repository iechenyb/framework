package com.cyb.push;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PushThread  implements Runnable{

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			Map map = new HashMap();
			map.put("x", random.nextInt(255));
			map.put("y", random.nextInt(255));
			map.put("z", random.nextInt(255));
			try {
				PushServer.sendBroadcast(map);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("push over....");
			}//广播推送消息
			
		}
		
	}

}
