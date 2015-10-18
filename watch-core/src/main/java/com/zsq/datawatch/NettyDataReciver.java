package com.zsq.datawatch;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Arrays;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsq.datawatch.entity.Machinfor;

/**
 * 基于NETTY的数据接收器
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: NettyDataReciver.java, V1.0.0 2015年10月17日 下午3:13:02 $
 */
public class NettyDataReciver implements InitializingBean, DisposableBean {

	public static final int SERVER_PORT = 8913;

	private ObjectMapper mapper;
	private DatagramSocket server;
	private ReciverDataHander dataHander;
	private DatagramPacket packet = null;

	/**
	 * 开始监听数据
	 */
	public void startReciver() throws Exception {
		System.out.println("[消息监听] 服务器启动 ~~~");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					server = new DatagramSocket(SERVER_PORT);
					while (true) {
						byte[] buffer = new byte[1024];
						packet = new DatagramPacket(buffer, buffer.length);
						server.receive(packet);
						Thread workthread = new Thread(new Handler(packet));
						workthread.start();
					}
				} catch (IOException e) {
					System.err.println("消息服务监听启动失败");
					e.printStackTrace();
				}
			}
		}).start();
		
	}

	/**
	 * 接收数据处理
	 * 
	 * @author peculiar.1@163.com
	 * @version $ID: NettyDataReciver.java, V1.0.0 2015年10月17日 下午3:32:27 $
	 */
	class Handler implements Runnable {

		private DatagramPacket packet;

		public Handler(DatagramPacket packet) {
			this.packet = packet;
		}

		@Override
		public void run() {
			Machinfor info = transforFromPacket(packet);
		}
		
	}

	/**
	 * 停止监听
	 */
	public void stopReciver() throws Exception {
		server.close();
	}

	/**
	 * 
	 * @param packet2
	 * @return
	 */
	private Machinfor transforFromPacket(DatagramPacket packet2) {
		if(packet2.getData() == null){
			return null;
		}
		
		byte[] bytes = packet2.getData();
		
		Machinfor info = new Machinfor();
		
		info.setMachnum(new String(Arrays.copyOfRange(bytes, 0, 16)));
		
		new String(Arrays.copyOfRange(bytes, 16, 32));
		new String(Arrays.copyOfRange(bytes, 64, 96));
		new String(Arrays.copyOfRange(bytes, 0, 32));
		
		return info;
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
