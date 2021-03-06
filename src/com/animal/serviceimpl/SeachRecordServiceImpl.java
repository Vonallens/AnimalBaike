package com.animal.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.animal.mapper.AnimalInfoMapper;
import com.animal.mapper.SeachRecordMapper;
import com.animal.model.AnimalInfo;
import com.animal.model.SeachRecord;
import com.animal.model.UserInfo;
import com.animal.service.AnimalInfoService;
import com.animal.service.SeachRecordService;
@Service
@Transactional
public class SeachRecordServiceImpl implements SeachRecordService{

	@Autowired
	private SeachRecordMapper seachRecordMapper;

	@Override
	public UserInfo getUserInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewSeachRecord(SeachRecord seachRecord) {
		// TODO Auto-generated method stub
		return seachRecordMapper.addNewSeachRecord(seachRecord);
	}

	//获取搜索数据排行。
	@Override
	public List<Map<String,String>> getSeachRank() {
		// TODO Auto-generated method stub
		return seachRecordMapper.getSeachRank();
	}

	@Override
	public List<Map<String, String>> getSeachRankBetweenMonth() {
		// TODO Auto-generated method stub
		return seachRecordMapper.getSeachRankBetweenMonth();
	}

	@Override
	public List<Map<String, String>> getSeachRankBetweenWeek() {
		// TODO Auto-generated method stub
		return seachRecordMapper.getSeachRankBetweenWeek();
	}

	@Override
	public List<String> getUserIdBySeachRecord(String seactRecord,String userId) {
		// TODO Auto-generated method stub
		return seachRecordMapper.getUserIdBySeachRecord(seactRecord,userId);
	}

	@Override
	public List<String> getSeachRecordByUserId(String userId,String seachRecord) {
		// TODO Auto-generated method stub
		return seachRecordMapper.getSeachRecordByUserId(userId,seachRecord);
	}

}
