package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	Optional<UserRole> findById(Long id);

}
