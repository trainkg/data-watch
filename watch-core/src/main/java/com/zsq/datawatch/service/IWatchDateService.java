package com.zsq.datawatch.service;

import java.util.List;

import com.zsq.datawatch.entity.Machinfor;

/**
 * 数据监测模块
 * @author peculiar.1@163.com
 * @version $ID: IWatchDateService.java, V1.0.0 2015年9月19日 下午5:51:24 $
 */
public interface IWatchDateService {

	/**
	 * 获取当前系统中当前所有机器的状态信息
	 * @return
	 */
	public List<Machinfor> getCurrentMachInfo();
}
