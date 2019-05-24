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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidin.tutoring.model.ScheduleBimbel;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.noentity.SalaryMentor;
import com.aidin.tutoring.repository.noentity.ScheduleBimbelMentor;
import com.aidin.tutoring.repository.noentity.ScheduleBimbelStudent;
import com.aidin.tutoring.service.ScheduleBimbelService;

@RestController
public class ScheduleBimbelController {
	
	@Autowired
	private ScheduleBimbelService scheduleService;
	
	@GetMapping("/ScheduleBimbel")
	public List<ScheduleBimbel> getAll() {
		return scheduleService.getAllScheduleBimbel();
	}
	
	@GetMapping("/ScheduleBimbel/{id}")
	public ScheduleBimbel getById(@PathVariable Long id) {
		return scheduleService.getScheduleBimbelById(id);
	}
	
	@PostMapping("/ScheduleBimbel")
	public ResponseEntity<?> saveOrUpdate(@RequestBody ScheduleBimbel schedule, User user) {
		if(StringUtils.isEmpty(schedule.getDate())) {
			return ResponseEntity.noContent().build();
		}else {
			boolean y = schedule.getPkschedulebimbel()==null;
			scheduleService.saveOrUpdateSchedule(schedule, user);
			if(y) {
				return ResponseEntity.ok().body("success create scheduleBimbel");
			}else {
				return ResponseEntity.ok().body("success update scheduleBimbel with pkschedulebimbel "+schedule.getPkschedulebimbel());
			}
		}
	}
	
	@GetMapping("/ScheduleBimbel/Student/{groupClass}")
	public ArrayList<ScheduleBimbelStudent> getAllByStudent(@PathVariable String groupClass) {
		return scheduleService.getAllScheduleByStudent(groupClass);
	}

	@GetMapping("/ScheduleBimbel/Mentor/{id}")
	public ArrayList<ScheduleBimbelMentor> getAllByMentor(@PathVariable Long id) {
		return scheduleService.getAllScheduleByMentor(id);
	}

	@GetMapping("/ScheduleBimbel/Date/{date}")
	public ArrayList<ScheduleBimbelMentor> getAllByAvailable(@PathVariable Date date) {
		return scheduleService.getAllScheduleByDate(date);
	}
	
	@GetMapping("/SalaryBimbel")
	public ArrayList<SalaryMentor> getAllSalaryMentor(Date start, Date end) {
		return scheduleService.getSalaryMentorBimbelInMount(start, end);
	}
	
}
