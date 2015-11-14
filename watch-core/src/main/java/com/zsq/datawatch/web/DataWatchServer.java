package com.zsq.datawatch.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsq.datawatch.NettyDataReciver;
import com.zsq.datawatch.ReciverDataHander;
import com.zsq.datawatch.entity.Machinfor;
import com.zsq.datawatch.service.IWatchDataService;

/**
 * 封装为一个 websocket 服务主要负责向客户端推送消息
 * @author zhuyy
 */
@ServerEndpoint(value="/iwatch",configurator = SpringConfigurator.class)
public class DataWatchServer{
	
	private Map<Session, Basic> listeners = new HashMap<Session, Basic>();
	
	private Logger log = LoggerFactory.getLogger(getClass());
	//是否已经添加监听
	private boolean addLis = false;
	
	@Autowired
	private NettyDataReciver machinfoDataReciver;
	
	@Autowired
	private IWatchDataService seWatch;
	
	@OnMessage
	public void onMessage(String message,Session session){
		log.info("reciver message, {}", message);
	}
	
	@OnOpen
	public void onOpen(Session session,EndpointConfig config){
		log.info("open data watch server");
		if(!addLis){
			addLisenter();
		}
		final Basic remote = session.getBasicRemote();
		listeners.put(session, remote);
	}
	
	/*
	 * 因为技术限制  MachinfoDataReciver 注入不了server 对象
	 * 数据流向是 MQ -> MachinfoDataReciver -> server -> page
	 */
	private void addLisenter() {
		machinfoDataReciver.setDataHander(new DataWatchDataHander());
	}

	@OnClose
	public void onClose(Session session,CloseReason reason){
		log.info("close data watch server");
		listeners.remove(session);
	}
	
	
	/**
	 * 默认的数据处理策略
	 * 
	 * @author peculiar.1@163.com
	 * @version $ID: MachinfoDataReciver.java, V1.0.0 2015年9月19日 下午5:55:25 $
	 */
	class DataWatchDataHander implements ReciverDataHander{
		
		/**
		 * 记录同一个MAC地址机器上一次接受到的数据时点<br>
		 * 通过事件间隔策略处理接受到的数据信息
		 */
		private Map<String,Long> map = new HashMap<String,Long>();
		
		public static final int SPLIT_TIME = 1 * 60 * 1000;
		
		private ObjectMapper mapper;
		
		public DataWatchDataHander() {
			mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
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
				int ip = new Random().nextInt(10);
				info.setMachip("machip"+ip);
				info.setMachmac("10.23.36."+ip);
				System.out.println(info.getMachmac());
				info.setMsgtype(String.valueOf(new Random().nextInt(3)));
				info.setMachmode("1");
				log.warn("读取传输信息格式失败", e);
			}
			return info;
		}
		
		
		@Override
		public void dataHander(String info) {
			Machinfor minfo = transforMachinfo(info);
			if(minfo != null) _dataHander(minfo);
		}

		@Override
		public void dataHander(Machinfor info) {
			if(info != null) _dataHander(info);
		}
		
		private void _dataHander(Machinfor minfo) {
			log.info("处理数据,IP ",minfo.getMachip());
			boolean needSave = Boolean.FALSE;
			Date date = new Date();
			String mac = minfo.getMachmac();
			if(map.get(mac) == null || map.get(mac) + SPLIT_TIME < date.getTime()){
				needSave = Boolean.TRUE;
				map.put(mac, date.getTime());
				
			}
			
			if(needSave){
				minfo.setReciverdate(new Date());
				seWatch.saveInfo(minfo);
			}
			
			for (Map.Entry<Session,RemoteEndpoint.Basic> entry : listeners.entrySet()) {
				try {
					entry.getValue().sendText(mapper.writeValueAsString(minfo));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}

	}


	
}
