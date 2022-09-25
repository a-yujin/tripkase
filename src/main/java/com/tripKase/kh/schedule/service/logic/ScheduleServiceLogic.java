package com.tripKase.kh.schedule.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;
import com.tripKase.kh.schedule.service.ScheduleService;
import com.tripKase.kh.schedule.store.ScheduleStore;

@Service
public class ScheduleServiceLogic implements ScheduleService {

	@Autowired
	private SqlSession session;	
	@Autowired
	private ScheduleStore sStore;
	
	@Override
	public List<Schedule> selectAllSchedule(String memberId) {
		List<Schedule> sList = sStore.selectAllSchedule(session, memberId);
		return sList;
	}

	@Override
	public int insertSchedule(Schedule schedule) {
		int result = sStore.insertSchedule(session,schedule);
		return result;
	}

	@Override
	public int AddDays(Schedule schedule) {
		int result = sStore.AddDays(session,schedule);
		return result;
	}

	@Override
	public List<Schedule> selectScheduleBySeq(int cheduleSeq) {
		List<Schedule> sList = sStore.selectScheduleBySeq(session,cheduleSeq);
		return sList;
	}

	@Override
	public List<ScheduleManage> selectSMBySeq(Integer chedulesSeq, String Days) {
		List<ScheduleManage> smList = sStore.selectSMBySeq(session,chedulesSeq, Days);
		return smList;
	}

	@Override
	public int getTotalDays(int cheduleSeq) {
		int result = sStore.getTotalDays(session,cheduleSeq);
		return result;
	}

}
