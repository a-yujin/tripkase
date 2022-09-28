package com.tripKase.kh.schedule.store;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;
import com.tripKase.kh.storage.domain.Storage;

public interface ScheduleStore {

	List<Schedule> selectAllSchedule(SqlSession session, String memberId);

	int insertSchedule(SqlSession session, Schedule schedule);

	int AddDays(SqlSession session, Schedule schedule);

	List<Schedule> selectScheduleBySeq(SqlSession session, int cheduleSeq);

	List<ScheduleManage> selectSMBySeq(SqlSession session, Integer cheduleSeq, String Days);

	int getTotalDays(SqlSession session, int cheduleSeq);

	Storage selectStoByNo(SqlSession session, int stoNo);

	int insertStorage(SqlSession session, Storage storage);

	List<Integer> dayCount(SqlSession session, String memberId);

	List<Schedule> selectAllstorage(SqlSession session, String memberId);

	int insertScheduleData(SqlSession session, HashMap<String, String> param);

}
