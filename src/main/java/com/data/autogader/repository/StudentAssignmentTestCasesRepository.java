package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.Professor;
import com.data.autogader.entity.StudentAssignmentTestCases;

@Repository
public interface StudentAssignmentTestCasesRepository  extends JpaRepository<StudentAssignmentTestCases, Long> {
	Optional<StudentAssignmentTestCases> findById(Long id);

}
