package com.cyb.activemq;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

import com.cyb.qutoes.listener.QutoesListener;
  
public class JMSMSGListener implements MessageListener {  
	MessageConsumer consumer;
	public JMSMSGListener(MessageConsumer consumer){
		this.consumer = consumer;
	}
	public static Logger log = Logger.getLogger(JMSMSGListener.class);
    public void onMessage(Message message) {  
        try {  
        	 MapMessage msg = (MapMessage)message;
        	 //log.info("activemq recived a message is " + new Date(msg.getLong("count")));
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
 }  
}