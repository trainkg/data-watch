package com.zsq.datawatch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zsq.datawatch.dao.MachinforMapper;
import com.zsq.datawatch.entity.Machinfor;
import com.zsq.datawatch.service.IWatchDataService;

@Service
@Transactional(readOnly = true)
public class WatchDataService implements IWatchDataService {

	@Autowired
	private MachinforMapper daoMinfo;
	
	@Override
	public List<Machinfor> getCurrentMachInfo() {
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveInfo(Machinfor info) {
		daoMinfo.insert(info);
	}
	

}
