package com.zsq.datawatch;

import com.zsq.datawatch.entity.Machinfor;


/**
 * 接收到的数据的处理策略
 * @author peculiar.1@163.com
 * @version $ID: ReciverDataHander.java, V1.0.0 2015年9月19日 下午5:54:13 $
 */
public interface ReciverDataHander {
	
	/**
	 * 处理数据 
	 * @param info
	 */
	void dataHander(String info);
	
	/**
	 * 处理数据, 不负责数据转换 
	 * @param info
	 */
	void dataHander(Machinfor info);
}
