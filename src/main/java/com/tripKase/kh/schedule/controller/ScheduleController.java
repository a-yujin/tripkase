package com.tripKase.kh.schedule.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tripKase.kh.member.domain.Member;
import com.tripKase.kh.schedule.domain.Schedule;
import com.tripKase.kh.schedule.domain.ScheduleManage;
import com.tripKase.kh.schedule.service.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleService sService;
	
	@RequestMapping("/schedule/scheduleView.tripkase")
	public ModelAndView scheduleList(
			ModelAndView mv
			,HttpSession session) {
		String memberId = ((Member)session.getAttribute("loginMember")).getMemberId();
		List<Schedule> sList = sService.selectAllSchedule(memberId);
		mv.addObject("sList",sList);
		mv.setViewName("/schedule/scheduleView");
		return mv;
	}
	
	@RequestMapping("/schedule/RegisteSchedule.tripkase")
	public ModelAndView RegisterSchedule(
			ModelAndView mv
			,@ModelAttribute Schedule schedule
			,HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		schedule.setMemberId(member.getMemberId());
		schedule.setScheduleDays("1일차");
		int result = sService.insertSchedule(schedule);
		
		//2일 이상 여행일 경우
		int diff= (int)((schedule.getScheduleEnd().getTime() - schedule.getScheduleStart().getTime())/(1000*60*60*24)) +1 ;
		if(diff > 1) {
			System.out.println(diff);
			for(int i = 2; i<=diff; i++) {
				schedule.setScheduleDays(i+"일차");
				result = sService.AddDays(schedule);
			}
		}
		mv.setViewName("redirect:/schedule/scheduleView.tripkase");
		return mv;
	}
	

	@RequestMapping("/schedule/scheduleDetail.tripkase")
	public ModelAndView scheduleDetail(
			ModelAndView mv
			,@RequestParam("scheduleSeq") Integer cheduleSeq
			,@RequestParam(value="scheduleDays", required = false) String scheduleDays
			,HttpSession session) {
		//스케줄 정보 가져오기
		String Days = (scheduleDays != null) ? scheduleDays : "1일차";
		List<Schedule> sList = sService.selectScheduleBySeq(cheduleSeq);
		List<ScheduleManage> smList = sService.selectSMBySeq(cheduleSeq,Days);
		mv.addObject("sList",sList);
		mv.addObject("smList",smList);
		mv.setViewName("/schedule/scheduleDetail");
		return mv;
	}
	
}
