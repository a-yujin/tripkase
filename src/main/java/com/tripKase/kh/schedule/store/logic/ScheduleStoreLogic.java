package com.tripKase.kh.schedule.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.store.ScheduleStore;

@Repository
public class ScheduleStoreLogic implements ScheduleStore{

	@Override
	public List<Schedule> selectAllSchedule(SqlSession session) {
		List<Schedule> sList = session.selectList("ScheduleMapper.selectAllSchedule");
		return sList;
	}

}
