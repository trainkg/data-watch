package com.zsq.datawatch;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger log = LoggerFactory.getLogger(getClass());
	private ObjectMapper mapper;
	private DatagramSocket server;
	/**
	 * # 交给了DataWatchServer 实例化
	 */
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
		
		Machinfor info = null;
		try {
			log.debug("接收数据开始，字节数数组长度 {}",packet2.getLength());
			byte[] bytes = packet2.getData();
			String msgInfo = new String(bytes);
			info = new Machinfor();
			String[] attrs = msgInfo.split("&");
			
			int x = 0;
			//头信息
			info.setMachnum(attrs[x++]);
			info.setMinorver(attrs[x++]);
			info.setMachmode(attrs[x++]);
			info.setMachmac(attrs[x++]);
			info.setMachip(attrs[x++]);//44
			log.info("接收到数据 ID 信息 {}",info.getMachip());
			info.setMachport(Integer.valueOf(attrs[x++],16));//44-46
			info.setMsgtype(attrs[x++]);
			//info.setContentlength(attrs[x++]);//48
			
			//结构体
			info.setCom1statue(Integer.valueOf(attrs[x++],16));
			info.setCom2statue(Integer.valueOf(attrs[x++],16));
			info.setAuststatue(Integer.valueOf(attrs[x++],16));
			info.setMachmotorstatue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setMachheartstatue(Integer.valueOf(String.valueOf(attrs[x++]),16)+""); 
			
			info.setTemper1statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper2statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper3statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper4statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper5statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper6statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper7statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper8statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+"");
			info.setTemper9statue(Integer.valueOf(String.valueOf(attrs[x++]),16)+""); //料温九段
			
			info.setTemper1value(Integer.valueOf(attrs[x++],16));
			info.setTemper2value(Integer.valueOf(attrs[x++],16));
			info.setTemper3value(Integer.valueOf(attrs[x++],16));
			info.setTemper4value(Integer.valueOf(attrs[x++],16));
			info.setTemper5value(Integer.valueOf(attrs[x++],16));
			info.setTemper6value(Integer.valueOf(attrs[x++],16));
			info.setTemper7value(Integer.valueOf(attrs[x++],16));
			info.setTemper8value(Integer.valueOf(attrs[x++],16));
			info.setTemper9value(Integer.valueOf(attrs[x++],16));
			info.setOiltempervalue(Integer.valueOf(attrs[x++],16)); //油温
			
			info.setOper1value(Integer.valueOf(attrs[x++],16));
			info.setOper2value(Integer.valueOf(attrs[x++],16));
			info.setOper3value(Integer.valueOf(attrs[x++],16));
			info.setOper4value(Integer.valueOf(attrs[x++],16));
			info.setOper5value(Integer.valueOf(attrs[x++],16));
			info.setOper6value(Integer.valueOf(attrs[x++],16));
			info.setOper7value(Integer.valueOf(attrs[x++],16));
			info.setOper8value(Integer.valueOf(attrs[x++],16));
			info.setOper9value(Integer.valueOf(attrs[x++],16)); //料温九段状态
			
			info.setRuler1value(Integer.valueOf(attrs[x++],16));
			info.setRuler2value(Integer.valueOf(attrs[x++],16));
			info.setRuler3value(Integer.valueOf(attrs[x++],16));
			info.setRuler4value(Integer.valueOf(attrs[x++],16));
			info.setRuler5value(Integer.valueOf(attrs[x++],16));
			info.setRuler6value(Integer.valueOf(attrs[x++],16));
			info.setRuler7value(Integer.valueOf(attrs[x++],16));
			info.setRuler8value(Integer.valueOf(attrs[x++],16)); //第八根电子尺 
			
			info.setWerrdata1(Integer.valueOf(attrs[x++],16));
			info.setWerrdata2(Integer.valueOf(attrs[x++],16));
			info.setWerrdata3(Integer.valueOf(attrs[x++],16));
			info.setWerrdata4(Integer.valueOf(attrs[x++],16));
			info.setWerrdata5(Integer.valueOf(attrs[x++],16));
			info.setWerrdata6(Integer.valueOf(attrs[x++],16));
			info.setWerrdata7(Integer.valueOf(attrs[x++],16));
			info.setWerrdata8(Integer.valueOf(attrs[x++],16));
			info.setWerrdata9(Integer.valueOf(attrs[x++],16));
			info.setWerrdata10(Integer.valueOf(attrs[x++],16));
			info.setWerrdata11(Integer.valueOf(attrs[x++],16));
			info.setWerrdata12(Integer.valueOf(attrs[x++],16));
			info.setWerrdata13(Integer.valueOf(attrs[x++],16));
			info.setWerrdata14(Integer.valueOf(attrs[x++],16));
			info.setWerrdata15(Integer.valueOf(attrs[x++],16));
			info.setWerrdata16(Integer.valueOf(attrs[x++],16));
			
			info.setWopermode(Integer.valueOf(attrs[x++],16));
			info.setWoperstep1(Integer.valueOf(attrs[x++],16));
			info.setWoperstep2(Integer.valueOf(attrs[x++],16));
			info.setWoperstep3(Integer.valueOf(attrs[x++],16));
			info.setWopersubstep1(Integer.valueOf(attrs[x++],16));
			info.setWopersubstep2(Integer.valueOf(attrs[x].substring(0,attrs[x].indexOf('$')),16));
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("接受数据处理异常",e);
		}
		
		/*int x = 0;
		//头信息
		info.setMachnum(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=2))));
		info.setMinorver(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=2))));
		info.setMachmode(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=2))));
		info.setMsgtype(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=2))));
		info.setMachmac(new String(Arrays.copyOfRange(bytes, x, x+=20)));
		info.setMachip(new String(Arrays.copyOfRange(bytes, x, x+=16)));//44
		log.info("接收到数据 ID 信息 {}",info.getMachip());
		info.setMachport(getValue(Arrays.copyOfRange(bytes, x, x+=2)));//44-46
		//info.setContentlength(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=2))));//48
		
		//结构体
		info.setCom1statue(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setCom2statue(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setAuststatue(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setMachmotorstatue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setMachheartstatue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4)))); 
		
		info.setTemper1statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper2statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper3statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper4statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper5statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper6statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper7statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper8statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4))));
		info.setTemper9statue(String.valueOf(getValue(Arrays.copyOfRange(bytes, x, x+=4)))); //料温九段
		
		info.setTemper1value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper2value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper3value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper4value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper5value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper6value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper7value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper8value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setTemper9value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOiltempervalue(getValue(Arrays.copyOfRange(bytes, x, x+=4))); //油温
		
		info.setOper1value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper2value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper3value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper4value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper5value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper6value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper7value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper8value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setOper9value(getValue(Arrays.copyOfRange(bytes, x, x+=4))); //料温九段状态
		
		info.setRuler1value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler2value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler3value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler4value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler5value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler6value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler7value(getValue(Arrays.copyOfRange(bytes, x, x+=4)));
		info.setRuler8value(getValue(Arrays.copyOfRange(bytes, x, x+=4))); //第八根电子尺 
*/		
		return info;
	}
	
	
	public Integer getValue(byte[] value){
		String s = "";
		for (int i = value.length-1; i > -1; i--) {
			System.out.println((char)value[i]);
			s+=value[i];
		}
		return Integer.valueOf(s,16);
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
