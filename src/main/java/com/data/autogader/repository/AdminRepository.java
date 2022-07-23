package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>  {
    Optional<Admin> findById(Long id);

}
