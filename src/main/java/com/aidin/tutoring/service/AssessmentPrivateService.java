package com.aidin.tutoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.AssessmentPrivate;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.AssessmentPrivateRepository;
import com.aidin.tutoring.repository.noentity.AssessmentDate;
import com.aidin.tutoring.repository.noentity.AssessmentMentor;
import com.aidin.tutoring.repository.noentity.AssessmentStudent;

@Service
@Transactional
public class AssessmentPrivateService {
	
	@Autowired
	private AssessmentPrivateRepository assessmentRepo;
	
	public List<AssessmentPrivate> getAllAssessmentPrivate() {
		return assessmentRepo.findAll();
	}
	
	public AssessmentPrivate getAssessmentPrivateById(long id) {
		return assessmentRepo.findByPkassessmentprivate(id);
	}
	
	public void saveOrUpdate(AssessmentPrivate data, User user) {
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
		assessmentRepo.save(data);
	}
	
	public ArrayList<AssessmentStudent> getAssessmentPrivateStudent(Long id) {
		return assessmentRepo.getAssessmentPrivateStudent(id);
	}

	public ArrayList<AssessmentMentor> getAssessmentPrivateMentor(Long id) {
		return assessmentRepo.getAssessmentPrivateMentor(id);
	}

	public ArrayList<AssessmentDate> getAssessmentPrivateDate(Date date) {
		return assessmentRepo.getAssessmentPrivateDate(date);
	}
	
}
