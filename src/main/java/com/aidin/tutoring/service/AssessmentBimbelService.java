package com.aidin.tutoring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.AssessmentBimbel;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.AssessmentBimbelRepository;
import com.aidin.tutoring.repository.noentity.AssessmentDate;
import com.aidin.tutoring.repository.noentity.AssessmentMentor;
import com.aidin.tutoring.repository.noentity.AssessmentStudent;

@Service
@Transactional
public class AssessmentBimbelService {
	
	@Autowired
	private AssessmentBimbelRepository assessmentRepo;
	
	public List<AssessmentBimbel> getAllAssessmentBimbel() {
		return assessmentRepo.findAll();
	}
	
	public AssessmentBimbel getAssessmentBimbelById(long id) {
		return assessmentRepo.findByPkassessmentbimbel(id);
	}
	
	public void saveOrUpdate(AssessmentBimbel data, User user) {
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
		return assessmentRepo.getAssessmentBimbelStudent(id);
	}

	public ArrayList<AssessmentMentor> getAssessmentPrivateMentor(Long id) {
		return assessmentRepo.getAssessmentBimbelMentor(id);
	}

	public ArrayList<AssessmentDate> getAssessmentPrivateDate(Date date) {
		return assessmentRepo.getAssessmentBimbelDate(date);
	}

	
}
