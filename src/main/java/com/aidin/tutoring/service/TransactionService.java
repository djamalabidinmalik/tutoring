package com.aidin.tutoring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidin.tutoring.model.Transaction;
import com.aidin.tutoring.model.User;
import com.aidin.tutoring.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	public List<Transaction> getAllTransaction() {
		return transactionRepo.findAll();
	}
	
	public Transaction getTransactionById(long id) {
		return transactionRepo.findByPktransaction(id);
	}
	
	public void saveOrUpdateTransaction(Transaction data, User user) {
		Date date = new Date();
		if(data.getCreateby()==null) {
			if(user.getName()==null) {
				data.setCreateby("System");
				data.setCreatedate(date);
				data.setModifyby("System");
				data.setModifydate(date);
			}else {
				data.setCreateby(user.getName());
				data.setCreatedate(date);
				data.setModifyby(user.getName());
				data.setModifydate(date);
			}
		}else {
			if(user.getName()!=null) {
				data.setModifyby(user.getName());
				data.setModifydate(date);
			}else {
				data.setModifyby("System");
				data.setModifydate(date);
			}
		}
		transactionRepo.save(data);
	}
	
}
