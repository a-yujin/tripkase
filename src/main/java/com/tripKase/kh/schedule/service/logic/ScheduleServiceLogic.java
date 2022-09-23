package com.tripKase.kh.schedule.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.service.ScheduleService;
import com.tripKase.kh.schedule.store.ScheduleStore;

@Service
public class ScheduleServiceLogic implements ScheduleService {

	@Autowired
	private SqlSession session;	
	@Autowired
	private ScheduleStore sStore;
	
	@Override
	public List<Schedule> selectAllSchedule() {
		List<Schedule> sList = sStore.selectAllSchedule(session);
		return sList;
	}

}
