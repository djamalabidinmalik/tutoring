package com.aidin.tutoring.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.SchedulePrivate;
import com.aidin.tutoring.repository.noentity.SalaryMentor;
import com.aidin.tutoring.repository.noentity.SchedulePrivateMentor;
import com.aidin.tutoring.repository.noentity.SchedulePrivateStudent;

@Repository
public interface SchedulePrivateRepository extends JpaRepository<SchedulePrivate, Long>{
	
	SchedulePrivate findByPkscheduleprivate(long id);
	
	SchedulePrivate findByFkstudentprivateInAndMentoridInAndFkcourse(Long fkstudentprivate, Long mentorid, Long fkcourse);
	
	List<SchedulePrivate> findByAvailable(boolean available);
	
	@Query("SELECT c.name as course, sp.available, u.name as mentor, ui.phone1 "
			+ "FROM SchedulePrivate sp "
			+ "inner join Course c on c.pkcourse = sp.fkcourse "
			+ "left join User u on u.pkuser = sp.mentorid "
			+ "left join UserInfo ui on ui.pkuserinfo = sp.mentorid "
			+ "where sp.fkstudentprivate = ?1")
	ArrayList<SchedulePrivateStudent> getSchedulePrivateStudent(Long id);
	
	@Query("SELECT c.name as course, sp.price, u.name as student, ui.phone1, ui.address1 "
			+ "FROM SchedulePrivate sp "
			+ "inner join Course c on c.pkcourse = sp.fkcourse "
			+ "left join User u on u.pkuser = sp.fkstudentprivate "
			+ "left join UserInfo ui on ui.pkuserinfo = sp.fkstudentprivate "
			+ "where sp.mentorid = ?1")
	ArrayList<SchedulePrivateMentor> getSchedulePrivateMentor(Long id);
	
	@Query("SELECT c.name as course, sp.price, u.name as student, ui.phone1, ui.address1 "
			+ "FROM SchedulePrivate sp "
			+ "inner join Course c on c.pkcourse = sp.fkcourse "
			+ "left join User u on u.pkuser = sp.fkstudentprivate "
			+ "left join UserInfo ui on ui.pkuserinfo = sp.fkstudentprivate "
			+ "where sp.available = true and sp.gender = ?1")
	ArrayList<SchedulePrivateMentor> getSchedulePrivateAvailable(String gender);

	@Query("SELECT count(sp.price) as price, u.name as mentor, ui.rekening "
			+ "FROM AssessmentPrivate ap "
			+ "inner join SchedulePrivate sp on sp.fkstudentprivate = ap.studentid and sp.mentorid = ap.mentorid "
			+ "inner join User u on u.pkuser = ap.mentorid "
			+ "inner join UserInfo ui on ui.pkuserinfo = ap.mentorid "
			+ "where date_format(ap.date, '%Y %m %d') between date_format(?1, '%Y %m %d') and date_format(?2, '%Y %m %d') "
			+ "group by ap.mentorid")
	ArrayList<SalaryMentor> getSalaryMentorByMount(Date start, Date end);		
	
}
