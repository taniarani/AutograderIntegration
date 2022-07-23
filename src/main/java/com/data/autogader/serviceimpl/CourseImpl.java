package com.data.autogader.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.autogader.entity.Course;
import com.data.autogader.model.CourseReqInfo;
import com.data.autogader.repository.CourseRepository;
import com.data.autogader.service.CourseService;

@Service
public class CourseImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public void save(CourseReqInfo courseReqInf) {

		Course course = new Course();
		course.setDetails(courseReqInf.getDetails());
		course.setName(courseReqInf.getName());
		courseRepository.save(course);
	}

	@Override
	public void update(CourseReqInfo courseReqInf, Long id) {
		Optional<Course> assignment = courseRepository.findById(id);
		if (assignment.isPresent()) {
			Course course = new Course();
			course.setId(id);
			course.setDetails(courseReqInf.getDetails());
			course.setName(courseReqInf.getName());
			courseRepository.save(course);
		}

	}

	@Override
	public void delete(Long id) {
		Optional<Course> assignment = courseRepository.findById(id);
		if (assignment.isPresent()) {
			courseRepository.deleteById(id);
		}

	}

}
