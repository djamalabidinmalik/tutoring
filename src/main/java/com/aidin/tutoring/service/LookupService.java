package com.aidin.tutoring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.Lookup;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.LookupRepository;

@Service
@Transactional
public class LookupService {

	@Autowired
	private LookupRepository lookupRepo;
	
	public List<Lookup> getAll(){
		return lookupRepo.findAll();
	}
	
	public List<Lookup> getParty(String party){
		return lookupRepo.findByParty(party);
	}
	
	public void saveOrUpdateCourse(Lookup data, User user) {
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
		lookupRepo.save(data);
	}
	
}
