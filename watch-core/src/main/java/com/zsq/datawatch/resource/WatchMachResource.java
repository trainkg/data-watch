package com.zsq.datawatch.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsq.datawatch.entity.Machinfor;
import com.zsq.datawatch.service.IWatchDataService;

/**
 * 和机器有关资源集合 
 * 
 * @author peculiar.1@163.com
 * @version $ID: WatchMachResource.java, V1.0.0 2015年11月13日 下午8:50:34 $
 */
@Controller
@RequestMapping("/watch/machine")
public class WatchMachResource {

	@Autowired
	private IWatchDataService seWatchData;
	
	/**
	 * 加载系统所有的机器信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public List<Machinfor> loadSystemMachinfos(){
		return seWatchData.getCurrentMachInfo();
	}
}
