package com.zsq.datawatch;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

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
	 * @version $ID: NettyDataReciver.java, V1.0.0 2015年10月17日 下午3:4:27 $
	 */
	class Handler implements Runnable {

		private DatagramPacket packet;

		public Handler(DatagramPacket packet) {
			this.packet = packet;
		}

		@Override
		public void run() {
			Machinfor info = transforFromPacket(packet);
			dataHander.dataHander(info);
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
		int x = 0;
		//头信息
		info.setMachnum(new String(Arrays.copyOfRange(bytes, x, x+=2)));
		info.setMinorver(new String(Arrays.copyOfRange(bytes, x, x+=2)));
		info.setMachmode(new String(Arrays.copyOfRange(bytes, x, x+=2)));
		info.setMsgtype(new String(Arrays.copyOfRange(bytes, x, x+=2)));
		info.setMachmac(new String(Arrays.copyOfRange(bytes, x, x+=20)));
		info.setMachip(new String(Arrays.copyOfRange(bytes, x, x+=16)));
		info.setMachport(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=2))));
		info.setContentlength(new String(Arrays.copyOfRange(bytes, x, x+=2)));//48
		
		//结构体
		info.setCom1statue(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setCom2statue(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setAuststatue(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setMachmotorstatue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setMachheartstatue(new String(Arrays.copyOfRange(bytes, x, x+=4))); 
		
		info.setTemper1statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper2statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper3statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper4statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper5statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper6statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper7statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper8statue(new String(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper9statue(new String(Arrays.copyOfRange(bytes, x, x+=4))); //料温九段
		
		info.setTemper1value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper2value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper3value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper4value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper5value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper6value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper7value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper8value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper9value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOiltempervalue(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4)))); //油温
		
		info.setOper1value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper2value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper3value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper4value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper5value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper6value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper7value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper8value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setOper9value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4)))); //料温九段状态
		
		info.setRuler1value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler2value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler3value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler4value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler5value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler6value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler7value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setRuler8value(Integer.valueOf(new String(Arrays.copyOfRange(bytes, x, x+=4)))); //第八根电子尺 
		
		return info;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
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
