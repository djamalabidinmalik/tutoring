package com.aidin.tutoring.repository.noentity;

import java.util.Date;

public interface StudentDetail {
	Long getId();
	String getName();
	String getUsername();
	String getPassword();
	String getGender();
	String getAddress1();
	String getAddress2();
	String getPhone1();
	String getPhone2();
	String getEmail();
	Date getBirthdate();
	String getGrade();
	String getRoomClass();
	String getGuardian();
	String getCourseList();
}
