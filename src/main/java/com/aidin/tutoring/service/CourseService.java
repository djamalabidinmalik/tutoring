package com.aidin.tutoring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.Course;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}
	
	public Course getCourseById(long id) {
		return courseRepo.findByPkcourse(id);
	}
	
	public void saveOrUpdateCourse(Course data, User user) {
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
		courseRepo.save(data);
	}
	
}
