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

import com.aidin.tutoring.model.Lookup;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.service.LookupService;

@RestController
public class LookupController {

	@Autowired
	private LookupService lookupService;
	
	@GetMapping("/Lookup")
	public List<Lookup> getAll(){
		return lookupService.getAll();
	}
	
	@GetMapping("/Lookup/{party}")
	public List<Lookup> getAll(@PathVariable String party){
		return lookupService.getParty(party);
	}
	
	@PostMapping("/Lookup")
	public ResponseEntity<?> saveOrUpdate(@RequestBody Lookup lookup, User user) {
		if(StringUtils.isEmpty(lookup.getLabel())) {
			return ResponseEntity.noContent().build();
		}else {
			boolean y = lookup.getPklookup()==null;
			lookupService.saveOrUpdateCourse(lookup, user);
			if(y) {
				return ResponseEntity.ok().body("success create course with name "+lookup.getLabel());
			}else {
				return ResponseEntity.ok().body("success update course with pkschedulebimbel "+lookup.getPklookup());
			}
		}
	}
}
