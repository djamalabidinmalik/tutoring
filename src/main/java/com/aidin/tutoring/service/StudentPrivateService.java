package com.aidin.tutoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.StudentPrivate;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.StudentPrivateRepository;

@Service
@Transactional
public class StudentPrivateService {
	
	@Autowired
	private StudentPrivateRepository studentPrivateRepo;
	
	public List<StudentPrivate> getAllStudentPrivate() {
		return studentPrivateRepo.findAll();
	}
	
	public StudentPrivate getStudentPrivateById(long id) {
		return studentPrivateRepo.findByPkstudentprivate(id);
	}
	
	public void saveProcess(StudentPrivate data, User user) {
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
		studentPrivateRepo.save(data);
	}
	
	public ResponseEntity<?> saveOrUpdateStudentPrivate(StudentPrivate data, User user) {
		boolean y = data.getPkstudentprivate()==null;
		saveProcess(data, user);
		if(y) {
			return ResponseEntity.ok().body("success create studentPrivate with studentid "+data.getStudentid());
		}else {
			return ResponseEntity.ok().body("success update studentPrivate with studentid "+data.getStudentid());
		}
	}
	
	public ResponseEntity<?> deleteStudentPrivate(StudentPrivate data, User user) {
		if(data.getPkstudentprivate() == null) {
			return ResponseEntity.noContent().build();
		}else{
			data.setActive(false);
			saveProcess(data, user);
			return ResponseEntity.ok().body("success delete user with pkuser "+user.getPkuser());
		}
	}
	
	public List<String> getStudentPrivateCourseList(StudentPrivate student) {
		List<String> list = new ArrayList<>();
		for(String key : student.getCourselist().split(",")) {
			list.add(key);
		}
		return list;
	}
	
}
