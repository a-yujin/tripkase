package com.tripKase.kh.schedule.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;

public interface ScheduleStore {

	List<Schedule> selectAllSchedule(SqlSession session, String memberId);

	int insertSchedule(SqlSession session, Schedule schedule);

	int AddDays(SqlSession session, Schedule schedule);

	List<Schedule> selectScheduleBySeq(SqlSession session, int cheduleSeq);

	List<ScheduleManage> selectSMBySeq(SqlSession session, Integer cheduleSeq, String Days);

	int getTotalDays(SqlSession session, int cheduleSeq);

}
