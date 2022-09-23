package com.tripKase.kh.schedule.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.service.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleService sService;
	
	@RequestMapping("/schedule/scheduleView.tripkase")
	public ModelAndView scheduleList(
			ModelAndView mv) {
		List<Schedule> sList = sService.selectAllSchedule();
		mv.addObject("sList",sList);
		mv.setViewName("/schedule/scheduleView");
		return mv;
	}
	
	@RequestMapping("/schedule/RegisteSchedule.tripkase")
	public ModelAndView RegisterSchedule(
			ModelAndView mv
			,@RequestParam("start") Date start
			,@RequestParam("end") Date end
			) {
		/* int result = sService.insertSchedule(); */
		mv.setViewName("redirect:/schedule/scheduleView.tripkase");
		return mv;
	}
	
}
