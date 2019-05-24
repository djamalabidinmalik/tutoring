package com.aidin.tutoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aidin.tutoring.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	Group findByPkusergroup(long id);
}
