package com.tripKase.kh.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;

public interface ScheduleService {
	
	List<Schedule> selectAllSchedule(String memberId);

	int insertSchedule(Schedule schedule);

	int AddDays(Schedule schedule);

	List<Schedule> selectScheduleBySeq(int cheduleSeq);

	List<ScheduleManage> selectSMBySeq(Integer cheduleSeq,String Days);

	int getTotalDays(int cheduleSeq);

}
