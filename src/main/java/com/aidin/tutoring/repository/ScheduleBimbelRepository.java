package com.aidin.tutoring.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.ScheduleBimbel;
import com.aidin.tutoring.repository.noentity.SalaryMentor;
import com.aidin.tutoring.repository.noentity.ScheduleBimbelMentor;
import com.aidin.tutoring.repository.noentity.ScheduleBimbelStudent;

@Repository
public interface ScheduleBimbelRepository extends JpaRepository<ScheduleBimbel, Long>{
	
	ScheduleBimbel findByPkschedulebimbel(long id);
	
	@Query("SELECT sb.date, sb.session, c.name as course, u.name as mentor, "
			+ "ui.phone1, sb.roomclass, sb.groupclass "
			+ "FROM ScheduleBimbel sb "
			+ "inner join Course c on c.pkcourse = sb.fkcourse "
			+ "inner join User u on u.pkuser = sb.mentorid "
			+ "inner join UserInfo ui on ui.pkuserinfo = sb.mentorid "
			+ "where sb.groupclass = ?1")
	ArrayList<ScheduleBimbelStudent> getScheduleBimbelStudent(String groupclass);
	
	@Query("SELECT sb.date, sb.session, c.name as course, sb.roomclass, sb.groupclass "
			+ "FROM ScheduleBimbel sb "
			+ "inner join Course c on c.pkcourse = sb.fkcourse "
			+ "where sb.mentorid = ?1")
	ArrayList<ScheduleBimbelMentor> getScheduleBimbelMentor(Long mentorid);
	
	@Query("SELECT sb.date, sb.session, c.name as course, u.name as mentor, "
			+ "ui.phone1, sb.roomclass, sb.groupclass "
			+ "FROM ScheduleBimbel sb "
			+ "inner join Course c on c.pkcourse = sb.fkcourse "
			+ "inner join User u on u.pkuser = sb.mentorid "
			+ "inner join UserInfo ui on ui.pkuserinfo = sb.mentorid "
			+ "where sb.date = ?1 ")
	ArrayList<ScheduleBimbelMentor> getScheduleBimbelDate(Date date);
	
	@Query("SELECT count(c.price) as price, u.name as mentor, ui.rekening "
			+ "FROM ScheduleBimbel sb "
			+ "inner join User u on u.pkuser = sb.mentorid "
			+ "inner join UserInfo ui on ui.pkuserinfo = sb.mentorid "
			+ "inner join Course c on c.pkcourse = sb.fkcourse "
			+ "where date_format(sb.date, '%Y %m %d') between date_format(?1, '%Y %m %d') and date_format(?2, '%Y %m %d') "
			+ "group by sb.mentorid")
	ArrayList<SalaryMentor> getSalaryMentorByMount(Date start, Date end);

}
