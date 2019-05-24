package com.aidin.tutoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidin.tutoring.model.User;
import com.aidin.tutoring.model.Transaction;
import com.aidin.tutoring.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/Transaction")
	public List<Transaction> getAll() {
		return transactionService.getAllTransaction();
	}
	
	@GetMapping("/Transaction/{id}")
	public Transaction getById(@PathVariable Long id) {
		return transactionService.getTransactionById(id);
	}
	
	@PostMapping("/Transaction")
	public ResponseEntity<?> saveOrUpdate(@RequestBody Transaction Transaction, User user) {
		if(StringUtils.isEmpty(Transaction.getJournal())) {
			return ResponseEntity.noContent().build();
		}else {
			transactionService.saveOrUpdateTransaction(Transaction, user);
			if(Transaction.getPktransaction() == null) {
				return ResponseEntity.ok().body("success create Transaction"); 
			}else {
				return ResponseEntity.ok().body("success update Transaction with pkTransaction "+Transaction.getPktransaction());
			}
		}
	}
}
