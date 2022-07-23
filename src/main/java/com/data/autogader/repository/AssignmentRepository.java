package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.Admin;
import com.data.autogader.entity.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	Optional<Assignment> findById(Long id);

}
