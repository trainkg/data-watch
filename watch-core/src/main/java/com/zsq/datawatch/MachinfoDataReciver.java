package com.zsq.datawatch;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class MachinfoDataReciver implements InitializingBean, DisposableBean {
	/**
	 * MQ 传输队列
	 */
	private final static String QUEUE_NAME = "ZSQ_WATCH";
	private String default_host = "localhost";
	private Logger log = LoggerFactory.getLogger(getClass());
	private ReciverDataHander dataHander = new DefaultDataHander();
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private ObjectMapper mapper;

	/**
	 * 
	 * @param message
	 */
	public void handerMessage(String message) {
		Machinfor info = transforMachinfo(message);
		dataHander.dataHander(info);
	}

	/*
	 * 消息转换
	 */
	private Machinfor transforMachinfo(String message) {
		Machinfor info = null;
		try {
			info = mapper.readValue(message, Machinfor.class);
		} catch (Exception e) {
			info = new Machinfor();
			info.setMachip("machip -- ip");
			info.setMachmac("10.23.36.4");
			log.warn("读取传输信息格式失败", e);
		}
		return info;
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
		// channel.exchangeDeclare("Ex", "fanout");
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,
					AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer); // 自动发送回执
	}

	/**
	 * 停止监听
	 */
	public void stopReciver() throws Exception {
		channel.close();
		connection.close();
	}

	/**
	 * 默认的数据处理策略
	 * 
	 * @author peculiar.1@163.com
	 * @version $ID: MachinfoDataReciver.java, V1.0.0 2015年9月19日 下午5:55:25 $
	 */
	class DefaultDataHander implements ReciverDataHander {

		@Override
		public void dataHander(Machinfor info) {
			System.out.println(info);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_DEFAULT);
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		startReciver();
	}

	@Override
	public void destroy() throws Exception {
		stopReciver();
	}

	public ReciverDataHander getDataHander() {
		return dataHander;
	}

	public void setDataHander(ReciverDataHander dataHander) {
		this.dataHander = dataHander;
	}

}
