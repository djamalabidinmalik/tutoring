package com.aidin.tutoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidin.tutoring.model.Course;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/Course")
	public List<Course> getAll() {
		return courseService.getAllCourse();
	}
	
	@GetMapping("/Course/{id}")
	public Course getById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping("/Course")
	public ResponseEntity<?> saveOrUpdate(@RequestBody Course course, User user) {
		if(StringUtils.isEmpty(course.getName())) {
			return ResponseEntity.noContent().build();
		}else {
			boolean y = course.getPkcourse()==null;
			courseService.saveOrUpdateCourse(course, user);
			if(y) {
				return ResponseEntity.ok().body("success create course with name "+course.getName());
			}else {
				return ResponseEntity.ok().body("success update course with pkschedulebimbel "+course.getPkcourse());
			}
		}
	}
	
}
