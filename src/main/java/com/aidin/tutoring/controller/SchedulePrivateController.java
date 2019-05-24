package com.aidin.tutoring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidin.tutoring.model.SchedulePrivate;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.noentity.SalaryMentor;
import com.aidin.tutoring.repository.noentity.SchedulePrivateMentor;
import com.aidin.tutoring.repository.noentity.SchedulePrivateStudent;
import com.aidin.tutoring.service.SchedulePrivateService;

@RestController
public class SchedulePrivateController {
	
	@Autowired
	private SchedulePrivateService scheduleService;
		
	@GetMapping("/SchedulePrivate")
	public List<SchedulePrivate> getAll() {
		return scheduleService.getAllSchedulePrivate();
	}
	
	@GetMapping("/SchedulePrivate/{id}")
	public SchedulePrivate getById(@PathVariable Long id) {
		return scheduleService.getSchedulePrivateById(id);
	}
	
	@PostMapping("/SchedulePrivate")
	public ResponseEntity<?> saveOrUpdate(@RequestBody SchedulePrivate schedule, User user) {
		if(StringUtils.isEmpty(schedule.getFkstudentprivate())) {
			return ResponseEntity.noContent().build();
		}else {
			return scheduleService.saveOrUpdateSchedulePrivate(schedule, user);
		}
	}
	
	@PutMapping("/SchedulePrivate/Accept")
	public ResponseEntity<?> accept(@RequestBody SchedulePrivate schedule, User user) {
		if(StringUtils.isEmpty(schedule.getPkscheduleprivate())) {
			return ResponseEntity.noContent().build();
		}else {
			return scheduleService.acceptSchedulePrivate(schedule, user);
		}
	}
	
	@PutMapping("/SchedulePrivate/Cancel")
	public ResponseEntity<?> cancel(@RequestBody SchedulePrivate schedule, User user) {
		if(StringUtils.isEmpty(schedule.getPkscheduleprivate())) {
			return ResponseEntity.noContent().build();
		}else {
			return scheduleService.cancelSchedulePrivate(schedule, user);
		}
	}
	
	@GetMapping("/SchedulePrivate/Student/{id}")
	public ArrayList<SchedulePrivateStudent> getAllByStudent(@PathVariable Long id) {
		return scheduleService.getSchedulePrivateStudent(id);
	}

	@GetMapping("/SchedulePrivate/Mentor/{id}")
	public ArrayList<SchedulePrivateMentor> getAllByMentor(@PathVariable Long id) {
		return scheduleService.getSchedulePrivateMentor(id);
	}

	@GetMapping("/SchedulePrivate/Date/{id}")
	public ArrayList<SchedulePrivateMentor> getAllByAvailable(@PathVariable Long id) {
		return scheduleService.getSchedulePrivateAvailable(id);
	}
	
	@GetMapping("/SalaryPrivate")
	public ArrayList<SalaryMentor> getAllSalaryMentor(Date start, Date end) {
		return scheduleService.getSalaryMentorPrivateInMount(start, end);
	}
	
}
