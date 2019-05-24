package com.aidin.tutoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.SchedulePrivate;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.model.UserInfo;
import com.aidin.tutoring.repository.SchedulePrivateRepository;
import com.aidin.tutoring.repository.noentity.SalaryMentor;
import com.aidin.tutoring.repository.noentity.SchedulePrivateMentor;
import com.aidin.tutoring.repository.noentity.SchedulePrivateStudent;

@Service
@Transactional
public class SchedulePrivateService {
	
	@Autowired
	private SchedulePrivateRepository schedulePrivateRepo;
	
	@Autowired
	private UserInfoService userService;
	
	public List<SchedulePrivate> getAllSchedulePrivate() {
		return schedulePrivateRepo.findAll();
	}
	
	public SchedulePrivate getSchedulePrivateById(long id) {
		return schedulePrivateRepo.findByPkscheduleprivate(id);
	}
	
	public void saveProcess(SchedulePrivate data, User user) {
		Date date = new Date();
		if(data.getCreateby()==null) {
			if(user.getName()==null) {
				data.setCreateby("System");
				data.setCreatedate(date);
				data.setModifyby("System");
				data.setModifydate(date);
			}else {
				data.setCreateby(user.getName());
				data.setCreatedate(date);
				data.setModifyby(user.getName());
				data.setModifydate(date);
			}
		}else {
			if(user.getName()!=null) {
				data.setModifyby(user.getName());
				data.setModifydate(date);
			}else {
				data.setModifyby("System");
				data.setModifydate(date);
			}
		}
		schedulePrivateRepo.save(data);
	}
	
	public ResponseEntity<?> saveOrUpdateSchedulePrivate(SchedulePrivate data, User user) {
		boolean y = data.getPkscheduleprivate()==null;
		saveProcess(data, user);
		if(y) {
			return ResponseEntity.ok().body("success create schedulePrivate");
		}else {
			return ResponseEntity.ok().body("success update schedulePrivate with pkscheduleprivate "+data.getPkscheduleprivate());
		}
	}
	
	public ResponseEntity<?> acceptSchedulePrivate(SchedulePrivate data, User user) {
		if(data.isAvailable()) {
			data.setMentorid(user.getPkuser());
			data.setAvailable(false);		
			saveProcess(data, user);
			return ResponseEntity.ok().body("success accept schedulePrivate with pkscheduleprivate "+data.getPkscheduleprivate());
		}else {
			return ResponseEntity.badRequest().body("error accept schedulePrivate, the schedulePrivate not available");
		}
		
	}
	
	public ResponseEntity<?> cancelSchedulePrivate(SchedulePrivate data, User user) {
		if(data.isAvailable() && data.getMentorid()==user.getPkuser()) {
			data.setMentorid(null);
			data.setAvailable(true);
			saveProcess(data, user);
			return ResponseEntity.ok().body("success cancel schedulePrivate with pkscheduleprivate "+data.getPkscheduleprivate());
		}else {
			return ResponseEntity.badRequest().body("error cancel schedulePrivate");
		}
	}
	
	public long getPrice(long fkStudentPrivate, long mentorId, long fkCourse) {
		SchedulePrivate schedule = schedulePrivateRepo.findByFkstudentprivateInAndMentoridInAndFkcourse(fkStudentPrivate, mentorId, fkCourse);
		return schedule.getPrice();
	}
	
	public ArrayList<SchedulePrivateStudent> getSchedulePrivateStudent(Long id) {
		return schedulePrivateRepo.getSchedulePrivateStudent(id);
	}

	public ArrayList<SchedulePrivateMentor> getSchedulePrivateMentor(Long id) {
		return schedulePrivateRepo.getSchedulePrivateMentor(id);
	}

	public ArrayList<SchedulePrivateMentor> getSchedulePrivateAvailable(Long id) {
		UserInfo mentor = userService.getUserInfoById(id);
		return schedulePrivateRepo.getSchedulePrivateAvailable(mentor.getGender());
	}
	
	public ArrayList<SalaryMentor> getSalaryMentorPrivateInMount(Date start, Date end) {
		return schedulePrivateRepo.getSalaryMentorByMount(start, end);
	}
}
