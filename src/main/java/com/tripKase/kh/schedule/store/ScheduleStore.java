package com.tripKase.kh.schedule.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.schedule.domain.Schedule;

public interface ScheduleStore {

	List<Schedule> selectAllSchedule(SqlSession session);

}
