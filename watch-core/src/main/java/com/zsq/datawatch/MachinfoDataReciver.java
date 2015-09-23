package com.zsq.datawatch;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.zsq.datawatch.entity.Machinfor;

/**
 * 数据接收器 
 * 
 * @author peculiar.1@163.com
 * @version $ID: MachinfoDataReciver.java, V1.0.0 2015年9月19日 下午5:53:37 $
 */
public class MachinfoDataReciver implements InitializingBean {
	/**
	 * MQ 传输队列
	 */
	private final static String QUEUE_NAME = "ZSQ_WATCH";
	private String default_host = "localhost";
	private Logger log = LoggerFactory.getLogger(getClass());
	private ReciverDataHander dataHander = new DefaultDataHander();
	
	/**
	 * 开始监听数据
	 */
	public void startReciver() throws Exception{
		log.info("开始监听服务采集数据");
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(default_host);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.exchangeDeclare("Ex", "fanout");
	    //channel.queueDeclare("EX", false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    Consumer consumer = new DefaultConsumer(channel) {
	        @Override
	        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	            throws IOException {
	          String message = new String(body, "UTF-8");
	          System.out.println(" [x] Received '" + message + "'");
	        }
	    };
	    channel.basicConsume(QUEUE_NAME, true, consumer); //自动发送回执
	}
	
	/**
	 * 默认的数据处理策略
	 * 
	 * @author peculiar.1@163.com
	 * @version $ID: MachinfoDataReciver.java, V1.0.0 2015年9月19日 下午5:55:25 $
	 */
	class DefaultDataHander implements ReciverDataHander{

		@Override
		public void dataHander(Machinfor info) {
			System.out.println(info);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("[after-property] machinfo");
	}

}
