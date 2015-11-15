package com.zsq.datawatch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zsq.datawatch.dao.AlarmtypeMapper;
import com.zsq.datawatch.dao.MachinforMapper;
import com.zsq.datawatch.dao.OpermodeMapper;
import com.zsq.datawatch.dao.OperstepmodeMapper;
import com.zsq.datawatch.entity.Alarmtype;
import com.zsq.datawatch.entity.Machinfor;
import com.zsq.datawatch.entity.Opermode;
import com.zsq.datawatch.entity.Operstepmode;
import com.zsq.datawatch.service.IWatchDataService;

@Service
@Transactional(readOnly = true)
public class WatchDataService implements IWatchDataService {

	@Autowired
	private MachinforMapper daoMinfo;
	
	@Autowired
	private AlarmtypeMapper daoAlar;
	
	@Autowired
	private OpermodeMapper daoOper;
	
	@Autowired
	private OperstepmodeMapper daoStep;
	
	@Override
	public List<Machinfor> getCurrentMachInfo() {
		return daoMinfo.getNewNodesAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveInfo(Machinfor info) {
		daoMinfo.insert(info);
	}

	@Override
	public List<Alarmtype> getAllAlarmtypes() {
		return daoAlar.findAll();
	}

	@Override
	public List<Opermode> getAllOpermodes() {
		return daoOper.findAll();
	}

	@Override
	public List<Operstepmode> getAllOperstepmodes() {
		return daoStep.findAll();
	}
	

}
