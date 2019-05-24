package com.aidin.tutoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.User;
import com.aidin.tutoring.model.UserInfo;
import com.aidin.tutoring.repository.UserRepository;
import com.aidin.tutoring.repository.noentity.MentorDetail;
import com.aidin.tutoring.repository.noentity.StudentDetail;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserInfoService userInfoService;
	
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	
	public List<User> getAllUserBy(String val) {
		String id = "%#%".replace("#", val);
		String name = "%#%".replace("#", val);
		String username = "%#%".replace("#", val);
		return userRepo.getUserByPkuserOrNameOrUsername(id, name, username);
	}
	
	public void saveProcess(User data, User user) {
		Date date = new Date();
		if(data.getCreateby()==null) {
			if(user.getName()==null) {
				data.setCreateby("System");
				data.setCreatedate(date);
				data.setModifyby("System");
				data.setModifydate(date);
			}else {
				data.setCreateby(user.getName());
				data.setCreatedate(date);
				data.setModifyby(user.getName());
				data.setModifydate(date);
			}
		}else {
			if(user.getName()!=null) {
				data.setModifyby(user.getName());
				data.setModifydate(date);
			}else {
				data.setModifyby("System");
				data.setModifydate(date);
			}
		}
		userRepo.save(data);
	}
	
	public ResponseEntity<?> saveOrUpdateUser(User data, User user) {
		boolean y = data.getPkuser()==null;
		saveProcess(data, user);
		if(y) {
			return ResponseEntity.ok().body("success create user with name "+data.getName());
		}else {
			return ResponseEntity.ok().body("success update user with pkuser "+data.getPkuser());
		}
	}
	
	public ResponseEntity<?> deleteUser(User data, User user) {
		UserInfo userInfo = userInfoService.getUserInfoById(data.getPkuser());
		if(data.getPkuser() == null || userInfo == null) {
			return ResponseEntity.noContent().build();
		}else{
			data.setActive(false);
			saveProcess(data, user);
			userInfo.setActive(false);
			userInfoService.saveOrUpdateUserInfo(userInfo, user);
			return ResponseEntity.ok().body("success delete user with pkuser "+user.getPkuser());
		}
	}
	
	public User getLogin(String username, String password) {
		return userRepo.findByUsernameInAndPassword(username, password);
	}
	
	public ArrayList<StudentDetail> getStudentDetail(Long id) {
		return userRepo.getStudentDetail(id);
	}
	
	public ArrayList<MentorDetail> getMentorDetail(Long id) {
		return userRepo.getMentorDetail(id);
	}
	
}
