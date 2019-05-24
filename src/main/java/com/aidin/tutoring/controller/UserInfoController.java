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

import com.aidin.tutoring.model.User;
import com.aidin.tutoring.model.UserInfo;
import com.aidin.tutoring.service.UserInfoService;

@RestController
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	

	@GetMapping("/UsersInfo")
	public List<UserInfo> getAll() {
		return userInfoService.getAllUserInfo();
	}
	
	@GetMapping("/UsersInfo/{id}")
	public UserInfo getById(@PathVariable Long id) {
		return userInfoService.getUserInfoById(id);
	}
	
	@PostMapping("/UsersInfo")
	public ResponseEntity<?> saveOrUpdate(@RequestBody UserInfo userInfo, User user) {
		if(StringUtils.isEmpty(userInfo.getGender())) {
			return ResponseEntity.noContent().build();
		}else {
			boolean y = userInfo.getPkuserinfo() == null;
			userInfoService.saveOrUpdateUserInfo(userInfo, user);
			if(y) {
				return ResponseEntity.ok().body("success create userInfo"); 
			}else {
				return ResponseEntity.ok().body("success update userInfo with pkuserinfo "+userInfo.getPkuserinfo());
			}
		}
	}
	
}
