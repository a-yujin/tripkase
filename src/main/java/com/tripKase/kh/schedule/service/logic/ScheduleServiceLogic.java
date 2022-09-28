package com.tripKase.kh.schedule.service.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;
import com.tripKase.kh.schedule.service.ScheduleService;
import com.tripKase.kh.schedule.store.ScheduleStore;
import com.tripKase.kh.storage.domain.Storage;

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

	@Override
	public Storage selectStoByNo(int stoNo) {
		Storage sto = sStore.selectStoByNo(session, stoNo);
		return sto;
	}

	@Override
	public int insertStorage(Storage storage) {
		int result = sStore.insertStorage(session, storage);
		return result;
	}

	@Override
	public List<Integer> dayCount(String memberId) {
		List<Integer> iList = sStore.dayCount(session, memberId);
		return iList;
	}

	@Override
	public List<Schedule> selectAllstorage(String memberId) {
		List<Schedule> sList = sStore.selectAllstorage(session, memberId);
		return sList;
	}

	@Override
	public int insertScheduleData(HashMap<String, String> param) {
		int result = sStore.insertScheduleData(session, param);
		return result;
	}

	@Override
	public int deleteSchedule(int scheduleSeq) {
		int result = sStore.deleteSchedule(session, scheduleSeq);
		return result;
	}

	@Override
	public int deleteScheduleData(int scheduleNo) {
		int result = sStore.deleteScheduleData(session, scheduleNo);
		return result;
	}

}
