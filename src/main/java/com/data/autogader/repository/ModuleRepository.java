package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.Module;


@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{
	Optional<Module> findById(Long id);


}
