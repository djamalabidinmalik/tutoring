package com.aidin.tutoring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.Lookup;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, Long>{
	List<Lookup> findByParty(String party);
}
