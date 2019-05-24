package com.aidin.tutoring.controller;

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

import com.aidin.tutoring.model.StudentPrivate;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.service.StudentPrivateService;

@RestController
public class StudentPrivateController {
	
	@Autowired
	private StudentPrivateService studentService;
	
	@GetMapping("/StudentPrivate")
	public List<StudentPrivate> getAll() {
		return studentService.getAllStudentPrivate();
	}
	
	@GetMapping("/StudentPrivate/{id}")
	public StudentPrivate getById(@PathVariable Long id) {
		return studentService.getStudentPrivateById(id);
	}
	
	@PostMapping("/StudentPrivate")
	public ResponseEntity<?> saveOrUpdate(@RequestBody StudentPrivate student, User user) {
		if(StringUtils.isEmpty(student.getStudentid())) {
			return ResponseEntity.noContent().build();
		}else {
			return studentService.saveOrUpdateStudentPrivate(student, user);
		}
	}
	
	@PutMapping("/StudentPrivate")
	public ResponseEntity<?> delete(@RequestBody StudentPrivate student, User user) {
		if(StringUtils.isEmpty(student.getPkstudentprivate())) {
			return ResponseEntity.noContent().build();
		}else {
			return studentService.deleteStudentPrivate(student, user);
		}
	}
}
