package com.aidin.tutoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.StudentPrivate;

@Repository
public interface StudentPrivateRepository extends JpaRepository<StudentPrivate, Long>{
	StudentPrivate findByPkstudentprivate(long id);
}
