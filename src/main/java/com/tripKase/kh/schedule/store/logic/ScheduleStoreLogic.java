package com.tripKase.kh.schedule.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;
import com.tripKase.kh.schedule.store.ScheduleStore;
import com.tripKase.kh.storage.domain.Storage;

@Repository
public class ScheduleStoreLogic implements ScheduleStore{

	//스케줄 리스트
	@Override
	public List<Schedule> selectAllSchedule(SqlSession session,String memberId) {
		List<Schedule> sList = session.selectList("ScheduleMapper.selectAllSchedule",memberId);
		return sList;
	}

	//스케줄 등록
	@Override
	public int insertSchedule(SqlSession session, Schedule schedule) {
		int result = session.insert("ScheduleMapper.insertSchedule",schedule);
		return result;
	}

	@Override
	public int AddDays(SqlSession session, Schedule schedule) {
		int result = session.insert("ScheduleMapper.AddDays",schedule);
		return result;
	}

	@Override
	public List<Schedule> selectScheduleBySeq(SqlSession session, int cheduleSeq) {
		List<Schedule> sList = session.selectList("ScheduleMapper.selectScheduleBySeq", cheduleSeq);
		return sList;
	}

	@Override
	public List<ScheduleManage> selectSMBySeq(SqlSession session, Integer cheduleSeq, String Days) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("cheduleSeq", String.valueOf(cheduleSeq));
		param.put("Days", Days);
		List<ScheduleManage> smList = session.selectList("ScheduleMapper.selectSMBySeq", param);
		return smList;
	}

	@Override
	public int getTotalDays(SqlSession session, int cheduleSeq) {
		int result = session.selectOne("ScheduleMapper.getTotalDays", cheduleSeq);
		return result;
	}

	@Override
	public Storage selectStoByNo(SqlSession session, int stoNo) {
		Storage sto = session.selectOne("ScheduleMapper.selectStoByNo", stoNo);
		return sto;
	}

	@Override
	public int insertStorage(SqlSession session, Storage storage) {
		int result = session.insert("ScheduleMapper.insertStorage", storage);
		return result;
	}

	@Override
	public List<Integer> dayCount(SqlSession session, String memberId) {
		List<Integer> iList = session.selectList("ScheduleMapper.dayCount", memberId);
		return iList;
	}

	@Override
	public List<Schedule> selectAllstorage(SqlSession session, String memberId) {
		List<Schedule> sList = session.selectList("ScheduleMapper.selectAllstorage",memberId);
		return sList;
	}

	@Override
	public int insertScheduleData(SqlSession session, HashMap<String, String> param) {
		int result = session.insert("ScheduleMapper.insertScheduleData", param);
		return result;
	}

	@Override
	public int deleteSchedule(SqlSession session, int scheduleSeq) {
		int result = session.delete("ScheduleMapper.deleteSchedule", scheduleSeq);
		return result;
	}

	@Override
	public int deleteScheduleData(SqlSession session, int scheduleNo) {
		int result = session.delete("ScheduleMapper.deleteScheduleData", scheduleNo);
		return result;
	}

}
