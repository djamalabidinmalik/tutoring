package com.aidin.tutoring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_transaction")
	private Long pktransaction;
	
	@Column(name="fk_user", nullable=false, insertable=true, updatable=true)
	private Long fkuser;
	
	@Column(name="transaction_date", nullable=false, insertable=true, updatable=true)
	private Date transactiondate;

	@Column(name="description", nullable=false, insertable=true, updatable=true)
	private String description;

	@Column(name="journal", nullable=false, insertable=true, updatable=true)
	private String journal;

	@Column(name="amount", nullable=false, insertable=true, updatable=true)
	private Long amount;

	@Column(name="create_by", nullable=false, insertable=true, updatable=false)
	private String createby;

	@Column(name="create_date", nullable=false, insertable=true, updatable=false)
	private Date createdate;

	@Column(name="modify_by", nullable=true, insertable=true, updatable=true)
	private String modifyby;
	
	@Column(name="modify_date", nullable=true, insertable=true, updatable=true)
	private Date modifydate;

	public Long getPktransaction() {
		return pktransaction;
	}

	public void setPktransaction(Long pktransaction) {
		this.pktransaction = pktransaction;
	}

	public Long getFkuser() {
		return fkuser;
	}

	public void setFkuser(Long fkuser) {
		this.fkuser = fkuser;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
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
