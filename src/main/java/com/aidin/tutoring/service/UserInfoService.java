package com.aidin.tutoring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.User;
import com.aidin.tutoring.model.UserInfo;
import com.aidin.tutoring.repository.UserInfoRepository;

@Service
@Transactional
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository userInfoRepo;
	
	public List<UserInfo> getAllUserInfo() {
		return userInfoRepo.findAll();
	}
	
	public UserInfo getUserInfoById(long id) {
		return userInfoRepo.findByPkuserinfo(id);
	}
	
	public void saveOrUpdateUserInfo(UserInfo data, User user) {
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
		userInfoRepo.save(data);
	}
	
}
