package com.zsq.datawatch.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zsq.datawatch.entity.Machinfor;
import com.zsq.datawatch.service.IWatchDataService;

@Service
@Transactional(readOnly = true)
public class WatchDataService implements IWatchDataService {

	@Override
	public List<Machinfor> getCurrentMachInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveInfo(Machinfor info) {
		System.out.println(info);
	}
	

}
