package com.tripKase.kh.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripKase.kh.schedule.domain.Schedule;

public interface ScheduleService {
	
	List<Schedule> selectAllSchedule();

}
