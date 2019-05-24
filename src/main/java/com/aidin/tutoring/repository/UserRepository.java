package com.aidin.tutoring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.noentity.MentorDetail;
import com.aidin.tutoring.repository.noentity.StudentDetail;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u "
			+ "where u.pkuser like ?1 "
			+ "or u.name like ?2 "
			+ "or u.username like ?3")
	List<User> getUserByPkuserOrNameOrUsername(String pkuser, String name, String username);
	
	User findByUsernameInAndPassword(String username, String password);
	
	@Query("SELECT u.pkuser as id, u.name, u.username, u.password, "
			+ "ui.gender, ui.address1, ui.address2, ui.phone1, ui.phone2, "
			+ "ui.email, ui.birthdate, ui.grade, ui.roomclass, "
			+ "ui.guardian, sp.courselist FROM User u "
			+ "inner join UserInfo ui on u.pkuser = ui.pkuserinfo "
			+ "left join StudentPrivate sp on sp.studentid = u.pkuser "
			+ "where u.pkuser = ?1")
	ArrayList<StudentDetail> getStudentDetail(Long id);
	
	@Query("SELECT u.pkuser as id, u.name, u.username, u.password, "
			+ "ui.gender, ui.address1, ui.address2, ui.phone1, ui.phone2, "
			+ "ui.email, ui.birthdate, ui.grade, ui.rekening "
			+ "FROM User u "
			+ "inner join UserInfo ui on u.pkuser = ui.pkuserinfo "
			+ "where u.pkuser = ?1")
	ArrayList<MentorDetail> getMentorDetail(Long id);
	
}
