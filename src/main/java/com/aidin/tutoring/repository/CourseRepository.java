package com.aidin.tutoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	Course findByPkcourse(long id);
}
