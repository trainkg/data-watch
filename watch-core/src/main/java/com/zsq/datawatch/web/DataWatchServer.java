package com.zsq.datawatch.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

		@Override
		public void dataHander(Machinfor info) {
			seWatch.saveInfo(info);
			for (Map.Entry<Session,RemoteEndpoint.Basic> entry : listeners.entrySet()) {
				try {
					entry.getValue().sendText("收到消息了");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
