package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_course")
	private Long pkcourse;
	
	@Column(name="name", nullable=false, insertable=true, updatable=true)
	private String name;

	@Column(name="grade", nullable=false, insertable=true, updatable=false)
	private String grade;

	@Column(name="price", nullable=false, insertable=true, updatable=false)
	private Long price;
	
	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;
	
	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=false, insertable=true, updatable=true)
	private String modifyby;
	
	@Column(name="modify_date", nullable=false, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkcourse() {
		return pkcourse;
	}

	public void setPkcourse(Long pkcourse) {
		this.pkcourse = pkcourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getModifyby() {
		return modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

}
