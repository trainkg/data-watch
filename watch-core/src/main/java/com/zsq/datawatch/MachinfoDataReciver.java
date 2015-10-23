package com.zsq.datawatch;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Rabbit MQ 数据接收器
 * 
 * @author peculiar.1@163.com
 * @version $ID: MachinfoDataReciver.java, V1.0.0 2015年9月19日 下午5:53:37 $
 */
public class MachinfoDataReciver implements InitializingBean, DisposableBean {
	/**
	 * MQ 传输队列
	 */
	private final static String EXCHANGE_NAME = "ZSQ_WATCH";
	private String default_host = "localhost";
	private Logger log = LoggerFactory.getLogger(getClass());
	private ReciverDataHander dataHander;
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;

	/**
	 * 
	 * @param message
	 */
	public void handerMessage(String message) {
		if(dataHander != null){
			dataHander.dataHander(message);
		}
	}

	/**
	 * 开始监听数据
	 */
	public void startReciver() throws Exception {
		log.info("开始监听服务采集数据");

		factory = new ConnectionFactory();
		factory.setHost(default_host);
		connection = factory.newConnection();
		channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
	    String queueName = channel.queueDeclare().getQueue();
	    channel.queueBind(queueName, EXCHANGE_NAME, "");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,
					AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body, "UTF-8");
				handerMessage(message);
			}
		};
		channel.basicConsume(queueName, true, consumer); // 自动发送回执
	}

	/**
	 * 停止监听
	 */
	public void stopReciver() throws Exception {
		channel.close();
		connection.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		startReciver();
	}

	@Override
	public void destroy() throws Exception {
		stopReciver();
	}

	public ReciverDataHander getDataHander() {
		return dataHander;
	}

	/**
	 * 设定消息接收器处理策略
	 * 
	 * @see ReciverDataHander
	 * @param dataHander
	 */
	public void setDataHander(ReciverDataHander dataHander) {
		this.dataHander = dataHander;
	}

}
