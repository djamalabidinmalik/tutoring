package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_private")
public class StudentPrivate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_student_private")
	private Long pkstudentprivate;

	@Column(name="student_id", nullable=false, insertable=true, updatable=true)
	private Long studentid;

	@Column(name="course_list", nullable=false, insertable=true, updatable=true)
	private String courselist;

	@Column(name="price", nullable=false, insertable=true, updatable=true)
	private Long price;

	@Column(name="total_price", nullable=false, insertable=true, updatable=true)
	private Long totalprice;

	@Column(name="active", nullable=false, insertable=true, updatable=true)
	private boolean active;

	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;

	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=false, insertable=true, updatable=true)
	private String modifyby;

	@Column(name="modify_date", nullable=false, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkstudentprivate() {
		return pkstudentprivate;
	}

	public void setPkstudentprivate(Long pkstudentprivate) {
		this.pkstudentprivate = pkstudentprivate;
	}

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public String getCourselist() {
		return courselist;
	}

	public void setCourselist(String courselist) {
		this.courselist = courselist;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
