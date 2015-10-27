package com.zsq.rabbitmq;


import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class Send {
	
	private final static String QUEUE_NAME = "ZSQ_WATCH";
	private static final String EXCHANGE_NAME = "ZSQ_WATCH";
	public static void main(String[] args) throws java.io.IOException,TimeoutException  {
		try {
			ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("localhost");
	        Connection connection = factory.newConnection();
	        Channel channel = connection.createChannel();

	        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

	        String message = "大家都是中国人,何必打打杀杀1";
	        for (int i = 0; i < 5; i++) {
	        	channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
	        	Thread.sleep(1000);
			}
	        System.out.println(" [x] Sent '" + message + "'");
	        
	        channel.close();
	        connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
