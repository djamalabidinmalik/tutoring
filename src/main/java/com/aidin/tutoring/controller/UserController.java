package com.aidin.tutoring.controller;

import java.util.ArrayList;
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

import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.noentity.MentorDetail;
import com.aidin.tutoring.repository.noentity.StudentDetail;
import com.aidin.tutoring.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/Login")
	public User login(@RequestBody String username, @RequestBody String password) {
		return userService.getLogin(username, password);
	}
	
	@GetMapping("/Users")
	public List<User> getAll() {
		return userService.getAllUser();
	}
	
	@GetMapping("/Users/{val}")
	public List<User> getAllBy(@PathVariable String val) {
		return userService.getAllUserBy(val);
	}
	
	@PostMapping("/Users")
	public ResponseEntity<?> saveOrUpdate(@RequestBody User user, User user1) {
		if(StringUtils.isEmpty(user.getName())) {
			return ResponseEntity.noContent().build();
		}else {
			return userService.saveOrUpdateUser(user, user1);
		}
	}
	
	@PutMapping("/Users")
	public ResponseEntity<?> delete(@RequestBody User user, User user1) {
		if(StringUtils.isEmpty(user.getPkuser())) {
			return ResponseEntity.noContent().build();
		}else {
			return userService.deleteUser(user, user1);
		}
	}
	
	@GetMapping("/Students/{id}")
	public ArrayList<StudentDetail> getStudent(@PathVariable Long id) {
		return userService.getStudentDetail(id);
	}

	@GetMapping("/Mentor/{id}")
	public ArrayList<MentorDetail> getMentor(@PathVariable Long id) {
		return userService.getMentorDetail(id);
	}
	
}
