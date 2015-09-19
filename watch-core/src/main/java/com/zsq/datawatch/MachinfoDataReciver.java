package com.zsq.datawatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.zsq.datawatch.entity.Machinfor;

/**
 * 数据接收器 
 * 
 * @author peculiar.1@163.com
 * @version $ID: MachinfoDataReciver.java, V1.0.0 2015年9月19日 下午5:53:37 $
 */
public class MachinfoDataReciver implements InitializingBean {
	private Logger log = LoggerFactory.getLogger(getClass());
	private ReciverDataHander dataHander = new DefaultDataHander();
	
	/**
	 * 开始监听数据
	 */
	public void startReciver(){
		
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
