package com.aidin.tutoring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidin.tutoring.model.AssessmentBimbel;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.noentity.AssessmentDate;
import com.aidin.tutoring.repository.noentity.AssessmentMentor;
import com.aidin.tutoring.repository.noentity.AssessmentStudent;
import com.aidin.tutoring.service.AssessmentBimbelService;

@RestController
public class AssessmentBimbelController {
	
	@Autowired
	private AssessmentBimbelService assessmentService;
	
	@GetMapping("/AssessmentBimbel")
	public List<AssessmentBimbel> getAll() {
		return assessmentService.getAllAssessmentBimbel();
	}
	
	@GetMapping("/AssessmentBimbel/{id}")
	public AssessmentBimbel getById(@PathVariable Long id) {
		return assessmentService.getAssessmentBimbelById(id);
	}
	
	@PostMapping("/AssessmentBimbel")
	public ResponseEntity<?> saveOrUpdate(@RequestBody AssessmentBimbel assessment, User user) {
		if(StringUtils.isEmpty(assessment.getDate())) {
			return ResponseEntity.noContent().build();
		}else {
			boolean y = assessment.getPkassessmentbimbel()==null;
			assessmentService.saveOrUpdate(assessment, user);
			if(y) {
				return ResponseEntity.ok().body("success create assessmentPrivate");
			}else {
				return ResponseEntity.ok().body("success update assessmentPrivate with pkschedulebimbel "+assessment.getPkassessmentbimbel());
			}
		}
	}

	@GetMapping("/AssessmentBimbel/Student/{id}")
	public ArrayList<AssessmentStudent> getAllByStudent(@PathVariable Long id) {
		return assessmentService.getAssessmentPrivateStudent(id);
	}

	@GetMapping("/AssessmentBimbel/Mentor/{id}")
	public ArrayList<AssessmentMentor> getAllByMentor(@PathVariable Long id) {
		return assessmentService.getAssessmentPrivateMentor(id);
	}

	@GetMapping("/AssessmentBimbel/Date/{date}")
	public ArrayList<AssessmentDate> getAllByAvailable(@PathVariable Date date) {
		return assessmentService.getAssessmentPrivateDate(date);
	}

}
