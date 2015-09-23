package com.zsq.rabbitmq;


import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class Send {
	
	private final static String QUEUE_NAME = "ZSQ_WATCH";
	private static final String EXCHANGE_NAME = "direct_logs";
	public static void main(String[] args) throws java.io.IOException,TimeoutException  {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, "direct");
			
			
			//channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "RANDOM info : int value "+ Math.random();
			for (int i = 0; i < 10; i++) {
				channel.basicPublish(EXCHANGE_NAME, "K3", null, ("["+i+"]"+message).getBytes());
			}
			System.out.println(" [x] Sent '" + message + "'");
			
			channel.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
