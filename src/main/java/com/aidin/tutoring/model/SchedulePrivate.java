package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule_private")
public class SchedulePrivate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_schedule_private")
	private Long pkscheduleprivate;
	
	@Column(name="fk_student_private", nullable=false, insertable=true, updatable=true)
	private Long fkstudentprivate;
	
	@Column(name="fk_course", nullable=false, insertable=true, updatable=true)
	private Long fkcourse;
	
	@Column(name="mentor_id", nullable=true, insertable=true, updatable=true)
	private Long mentorid;

	@Column(name="gender", nullable=false, insertable=true, updatable=false)
	private String gender;
	
	@Column(name="price", nullable=false, insertable=true, updatable=true)
	private Long price;
	
	@Column(name="available", nullable=false, insertable=true, updatable=true)
	private boolean available;
	
	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;
	
	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=false, insertable=true, updatable=true)
	private String modifyby;
	
	@Column(name="modify_date", nullable=false, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkscheduleprivate() {
		return pkscheduleprivate;
	}

	public void setPkscheduleprivate(Long pkscheduleprivate) {
		this.pkscheduleprivate = pkscheduleprivate;
	}

	public Long getFkstudentprivate() {
		return fkstudentprivate;
	}

	public void setFkstudentprivate(Long fkstudentprivate) {
		this.fkstudentprivate = fkstudentprivate;
	}

	public Long getFkcourse() {
		return fkcourse;
	}

	public void setFkcourse(Long fkcourse) {
		this.fkcourse = fkcourse;
	}

	public Long getMentorid() {
		return mentorid;
	}

	public void setMentorid(Long mentorid) {
		this.mentorid = mentorid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
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
