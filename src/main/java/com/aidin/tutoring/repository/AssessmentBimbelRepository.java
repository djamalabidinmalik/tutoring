package com.aidin.tutoring.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.AssessmentBimbel;
import com.aidin.tutoring.repository.noentity.AssessmentDate;
import com.aidin.tutoring.repository.noentity.AssessmentMentor;
import com.aidin.tutoring.repository.noentity.AssessmentStudent;

@Repository
public interface AssessmentBimbelRepository extends JpaRepository<AssessmentBimbel, Long>{
	
	AssessmentBimbel findByPkassessmentbimbel(long id);
	
	@Query("SELECT ab.date, c.name as course, u.name as mentor, ab.valuation, ab.note "
			+ "FROM AssessmentBimbel ab "
			+ "inner join User u on u.pkuser = ab.mentorid "
			+ "inner join Course c on c.pkcourse = ab.fkcourse "
			+ "where ab.studentid = ?1")
	ArrayList<AssessmentStudent> getAssessmentBimbelStudent(Long id);
	
	@Query("SELECT ab.date, c.name as course, u.name as student, ab.valuation, ab.note "
			+ "FROM AssessmentBimbel ab "
			+ "inner join User u on u.pkuser = ab.studentid "
			+ "inner join Course c on c.pkcourse = ab.fkcourse "
			+ "where ab.mentorid = ?1")
	ArrayList<AssessmentMentor> getAssessmentBimbelMentor(Long id);
	
	@Query("SELECT ab.date, c.name as course, u1.name as student, u2.name as mentor, ab.valuation, ab.note "
			+ "FROM AssessmentBimbel ab "
			+ "inner join User u1 on u1.pkuser = ab.studentid "
			+ "inner join User u2 on u2.pkuser = ab.mentorid "
			+ "inner join Course c on c.pkcourse = ab.fkcourse "
			+ "where ab.date = ?1")
	ArrayList<AssessmentDate> getAssessmentBimbelDate(Date date);

}
