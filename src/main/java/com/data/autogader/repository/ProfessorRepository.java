package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	Optional<Professor> findById(Long id);

}
