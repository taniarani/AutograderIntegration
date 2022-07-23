package com.data.autogader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.autogader.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>  {
	Optional<Course> findById(Long id);

}
