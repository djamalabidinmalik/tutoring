package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assessment_bimbel")
public class AssessmentBimbel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_assessment_bimbel")
	private Long pkassessmentbimbel;

	@Column(name="date", nullable=false, insertable=true, updatable=false)
	private Date date;

	@Column(name="student_id", nullable=false, insertable=true, updatable=true)
	private Long studentid;

	@Column(name="mentor_id", nullable=false, insertable=true, updatable=true)
	private Long mentorid;

	@Column(name="fk_course", nullable=false, insertable=true, updatable=true)
	private Long fkcourse;

	@Column(name="valuation", nullable=false, insertable=true, updatable=true)
	private String valuation;

	@Column(name="note", nullable=true, insertable=true, updatable=true)
	private String note;

	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;

	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=false, insertable=true, updatable=true)
	private String modifyby;

	@Column(name="modify_date", nullable=false, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkassessmentbimbel() {
		return pkassessmentbimbel;
	}

	public void setPkassessmentbimbel(Long pkassessmentbimbel) {
		this.pkassessmentbimbel = pkassessmentbimbel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public Long getMentorid() {
		return mentorid;
	}

	public void setMentorid(Long mentorid) {
		this.mentorid = mentorid;
	}

	public Long getFkcourse() {
		return fkcourse;
	}

	public void setFkcourse(Long fkcourse) {
		this.fkcourse = fkcourse;
	}

	public String getValuation() {
		return valuation;
	}

	public void setValuation(String valuation) {
		this.valuation = valuation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
