package com.cyb.push;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cyb.utils.H2Manager;
public class PushServerListener implements ServletContextListener {
    public PushServerListener() {
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	H2Manager.shutdown();
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	try {
			H2Manager.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
