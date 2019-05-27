package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lookup")
public class Lookup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_lookup")
	private Long pklookup;

	@Column(name="label", nullable=false, insertable=true, updatable=true)
	private String label;

	@Column(name="description", nullable=false, insertable=true, updatable=true)
	private String description;

	@Column(name="party", nullable=false, insertable=true, updatable=true)
	private String party;

	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;

	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=false, insertable=true, updatable=true)
	private String modifyby;

	@Column(name="modify_date", nullable=false, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPklookup() {
		return pklookup;
	}

	public void setPklookup(Long pklookup) {
		this.pklookup = pklookup;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
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
