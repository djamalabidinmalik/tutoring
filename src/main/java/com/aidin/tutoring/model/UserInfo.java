package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_user_info")
	private Long pkuserinfo;
	
	@Column(name="gender", nullable=false, insertable=true, updatable=true)
	private String gender;

	@Column(name="address1", nullable=true, insertable=true, updatable=true)
	private String address1;

	@Column(name="address2", nullable=true, insertable=true, updatable=true)
	private String address2;

	@Column(name="phone1", nullable=true, insertable=true, updatable=true)
	private String phone1;

	@Column(name="phone2", nullable=true, insertable=true, updatable=true)
	private String phone2;

	@Column(name="grade", nullable=false, insertable=true, updatable=true)
	private String grade;

	@Column(name="group_class", nullable=true, insertable=true, updatable=true)
	private String goupclass;

	@Column(name="room_class", nullable=true, insertable=true, updatable=true)
	private String roomclass;

	@Column(name="email", nullable=true, insertable=true, updatable=true)
	private String email;

	@Column(name="birthdate", nullable=true, insertable=true, updatable=true)
	private Date birthdate;

	@Column(name="guardian", nullable=true, insertable=true, updatable=true)
	private String guardian;

	@Column(name="rekening", nullable=true, insertable=true, updatable=true)
	private String rekening;

	@Column(name="active", nullable=false, insertable=true, updatable=true)
	private boolean active;

	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;
	
	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=true, insertable=true, updatable=true)
	private String modifyby;
	
	@Column(name="modify_date", nullable=true, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkuserinfo() {
		return pkuserinfo;
	}

	public void setPkuserinfo(Long pkuserinfo) {
		this.pkuserinfo = pkuserinfo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGoupclass() {
		return goupclass;
	}

	public void setGoupclass(String goupclass) {
		this.goupclass = goupclass;
	}

	public String getRoomclass() {
		return roomclass;
	}

	public void setRoomclass(String roomclass) {
		this.roomclass = roomclass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getRekening() {
		return rekening;
	}

	public void setRekening(String rekening) {
		this.rekening = rekening;
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
