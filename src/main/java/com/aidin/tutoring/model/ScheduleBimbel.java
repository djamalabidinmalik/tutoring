package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule_bimbel")
public class ScheduleBimbel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_schedule_bimbel")
	private Long pkschedulebimbel;
	
	@Column(name="fk_course", nullable=false, insertable=true, updatable=true)
	private Long fkcourse;

	@Column(name="date", nullable=false, insertable=true, updatable=false)
	private Date date;

	@Column(name="session", nullable=false, insertable=true, updatable=true)
	private String session;

	@Column(name="grade", nullable=false, insertable=true, updatable=true)
	private String grade;

	@Column(name="mentor_id", nullable=false, insertable=true, updatable=true)
	private Long mentorid;

	@Column(name="goup_class", nullable=false, insertable=true, updatable=true)
	private String groupclass;

	@Column(name="room_class", nullable=false, insertable=true, updatable=true)
	private String roomclass;
	
	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;
	
	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=false, insertable=true, updatable=true)
	private String modifyby;
	
	@Column(name="modify_date", nullable=false, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkschedulebimbel() {
		return pkschedulebimbel;
	}

	public void setPkschedulebimbel(Long pkschedulebimbel) {
		this.pkschedulebimbel = pkschedulebimbel;
	}

	public Long getFkcourse() {
		return fkcourse;
	}

	public void setFkcourse(Long fkcourse) {
		this.fkcourse = fkcourse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getMentorid() {
		return mentorid;
	}

	public void setMentorid(Long mentorid) {
		this.mentorid = mentorid;
	}

	public String getGroupclass() {
		return groupclass;
	}

	public void setGroupclass(String groupclass) {
		this.groupclass = groupclass;
	}

	public String getRoomclass() {
		return roomclass;
	}

	public void setRoomclass(String roomclass) {
		this.roomclass = roomclass;
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
