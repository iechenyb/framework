package com.cyb.activemq;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.hsqldb.lib.HashMap;

public class ReceiveTopic implements Runnable {
	  private String threadName;
      static String url = "tcp://localhost:61616";
	  
      static Map data = new LinkedHashMap();
      ReceiveTopic(String threadName) {

           this.threadName = threadName;

      }

 

      public void run() {

           // ConnectionFactory：连接工厂，JMS用它创建连接

           ConnectionFactory connectionFactory;

           // Connection：JMS客户端到JMS Provider的连接

           Connection connection = null;

           // Session：一个发送或接收消息的线程

           Session session;

           // Destination：消息的目的地;消息发送给谁.

           Destination destination;

           //消费者，消息接收者

           MessageConsumer consumer;

           connectionFactory = new ActiveMQConnectionFactory(

                      ActiveMQConnection. DEFAULT_USER,

                      ActiveMQConnection. DEFAULT_PASSWORD,url);

           try {

                 //构造从工厂得到连接对象

                 connection = connectionFactory.createConnection();

                 //启动

                 connection.start();

                 //获取操作连接,默认自动向服务器发送接收成功的响应

                 session = connection.createSession( false, Session. AUTO_ACKNOWLEDGE);

                 //获取session注意参数值FirstTopic是一个服务器的topic

                 destination = session.createTopic("FirstTopic");

                 consumer = session.createConsumer(destination);

                 while ( true) {

                      //设置接收者接收消息的时间，为了便于测试，这里设定为1s

                      TextMessage message = (TextMessage) consumer

                                  .receive();

                      if ( null != message) {
                    	    data.put(message.getText(), threadName);
                            System. out.println("线程"+threadName+"收到消息:" + message.getText());
                            //session.commit();

                      } else {

                            continue;

                      }
                     

                 }
                 //System.out.println(data);

           } catch (Exception e) {

                 e.printStackTrace();

           } finally {

                 try {

                      if ( null != connection)

                            connection.close();

                 } catch (Throwable ignore) {

                 }

           }
      }
}
