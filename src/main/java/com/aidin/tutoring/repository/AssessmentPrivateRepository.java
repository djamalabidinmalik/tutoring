package com.aidin.tutoring.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.AssessmentPrivate;
import com.aidin.tutoring.repository.noentity.AssessmentDate;
import com.aidin.tutoring.repository.noentity.AssessmentMentor;
import com.aidin.tutoring.repository.noentity.AssessmentStudent;

@Repository
public interface AssessmentPrivateRepository extends JpaRepository<AssessmentPrivate, Long>{
	
	AssessmentPrivate findByPkassessmentprivate(long id);
	
	@Query("SELECT ap.date, c.name as course, u.name as mentor, ap.description, ap.note "
			+ "FROM AssessmentPrivate ap "
			+ "inner join User u on u.pkuser = ap.mentorid "
			+ "inner join Course c on c.pkcourse = ap.fkcourse "
			+ "where ap.studentid = ?1")
	ArrayList<AssessmentStudent> getAssessmentPrivateStudent(Long id);
	
	@Query("SELECT ap.date, c.name as course, u.name as student, ap.description, ap.note "
			+ "FROM AssessmentPrivate ap "
			+ "inner join User u on u.pkuser = ap.studentid "
			+ "inner join Course c on c.pkcourse = ap.fkcourse "
			+ "where ap.mentorid = ?1")
	ArrayList<AssessmentMentor> getAssessmentPrivateMentor(Long id);
	
	@Query("SELECT ap.date, c.name as course, u1.name as student, u2.name as mentor, ap.description, ap.note "
			+ "FROM AssessmentPrivate ap "
			+ "inner join User u1 on u1.pkuser = ap.studentid "
			+ "inner join User u2 on u2.pkuser = ap.mentorid "
			+ "inner join Course c on c.pkcourse = ap.fkcourse "
			+ "where ap.date = ?1")
	ArrayList<AssessmentDate> getAssessmentPrivateDate(Date date);
	
}
