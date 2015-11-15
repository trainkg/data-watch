package com.zsq.datawatch.service;

import java.util.List;

import com.zsq.datawatch.entity.Alarmtype;
import com.zsq.datawatch.entity.Machinfor;
import com.zsq.datawatch.entity.Opermode;
import com.zsq.datawatch.entity.Operstepmode;

/**
 * 数据监测模块
 * @author peculiar.1@163.com
 * @version $ID: IWatchDateService.java, V1.0.0 2015年9月19日 下午5:51:24 $
 */
public interface IWatchDataService {

	/**
	 * 获取当前系统中当前所有机器的最新状态信息
	 * @return
	 */
	public List<Machinfor> getCurrentMachInfo();
	
	/**
	 * 保存一条指标信息
	 * @param info
	 */
	public void saveInfo(Machinfor info);

	/**
	 * @return
	 */
	public List<Alarmtype> getAllAlarmtypes();

	public List<Opermode> getAllOpermodes();

	public List<Operstepmode> getAllOperstepmodes();
}
