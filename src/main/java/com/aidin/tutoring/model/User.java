package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_user")
	private Long pkuser;
	
	@Column(name="name", nullable=false, insertable=true, updatable=true)
	private String name;
	
	@Column(name="username", nullable=false, insertable=true, updatable=true)
	private String username;
	
	@Column(name="password", nullable=false, insertable=true, updatable=true)
	private String password;
	
	@Column(name="fk_group", nullable=false, insertable=true, updatable=true)
	private int fkgroup;
	
	@Column(name="active", nullable=false, insertable=true, updatable=true)
	private Boolean active;
	
	@Column(name="last_login", nullable=false, insertable=true, updatable=true)
	private Date lastlogin;
	
	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;
	
	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=true, insertable=true, updatable=true)
	private String modifyby;
	
	@Column(name="modify_date", nullable=true, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPkuser() {
		return pkuser;
	}

	public void setPkuser(Long pkuser) {
		this.pkuser = pkuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFkgroup() {
		return fkgroup;
	}

	public void setFkgroup(int fkgroup) {
		this.fkgroup = fkgroup;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
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
