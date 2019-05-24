package com.aidin.tutoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.ScheduleBimbel;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.ScheduleBimbelRepository;
import com.aidin.tutoring.repository.noentity.SalaryMentor;
import com.aidin.tutoring.repository.noentity.ScheduleBimbelMentor;
import com.aidin.tutoring.repository.noentity.ScheduleBimbelStudent;

@Service
@Transactional
public class ScheduleBimbelService {
	
	@Autowired
	private ScheduleBimbelRepository scheduleBimbelRepo;
	
	public List<ScheduleBimbel> getAllScheduleBimbel() {
		return scheduleBimbelRepo.findAll();
	}
	
	public ScheduleBimbel getScheduleBimbelById(long id) {
		return scheduleBimbelRepo.findByPkschedulebimbel(id);
	}
	
	public void saveOrUpdateSchedule(ScheduleBimbel data, User user) {
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
		scheduleBimbelRepo.save(data);
	}
	
	public ArrayList<ScheduleBimbelStudent> getAllScheduleByStudent(String groupClass) {
		return scheduleBimbelRepo.getScheduleBimbelStudent(groupClass);
	}
	
	public ArrayList<ScheduleBimbelMentor> getAllScheduleByMentor(Long mentorId) {
		return scheduleBimbelRepo.getScheduleBimbelMentor(mentorId);
	}
	
	public ArrayList<ScheduleBimbelMentor> getAllScheduleByDate(Date date) {
		return scheduleBimbelRepo.getScheduleBimbelDate(date);
	}
	
	public ArrayList<SalaryMentor> getSalaryMentorBimbelInMount(Date start, Date end) {
		return scheduleBimbelRepo.getSalaryMentorByMount(start, end);
	}
	
}
